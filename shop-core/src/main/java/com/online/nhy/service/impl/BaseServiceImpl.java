package com.online.nhy.service.impl;

import com.online.nhy.annoation.ParentId;
import com.online.nhy.baseMapper.CxBaseMapper;
import com.online.nhy.constant.CommonConstants;
import com.online.nhy.domain.BasePo;
import com.online.nhy.exception.ServiceException;
import com.online.nhy.service.IBaseService;
import com.online.nhy.util.DateUtil;
import com.online.nhy.util.Pagination;
import com.online.nhy.util.PaginationResult;
import com.online.nhy.vo.BaseVo;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Version;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class BaseServiceImpl<P extends BasePo, Mapper extends CxBaseMapper<P>> implements IBaseService<P, Mapper>,
        ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    // Dal实体对象
    private Mapper baseMapper;

    // Dal实体类
    private Class<Mapper> mapperClass;

    // Po实体类
    private Class<P> PoClass;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.baseMapper = applicationContext.getBean(mapperClass);
    }

    @Override
    public CxBaseMapper<P> getMapper() {
        return baseMapper;
    }

    /**
     * 构造函数
     */
    @SuppressWarnings("unchecked")
    public BaseServiceImpl() {
        Type genType = getClass().getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

            if (params[0].getClass().isInstance(BasePo.class)) {
                this.PoClass = (Class<P>) params[0];
            }
            if (params[1].getClass().isInstance(CxBaseMapper.class)) {
                this.mapperClass = (Class<Mapper>) params[1];
            }
        }
    }

    @Override
    public Long getLoginUserId() {
        return 10l;
    }

    /*
     * Vo对象转换成Po对象
     * @param vo Vo对象
     * @return Po对象
     */
    private <V extends BaseVo> P convert2Po(V vo) {
        try {
            P po = PoClass.newInstance();
            BeanUtils.copyProperties(vo,po);
            return po;
        } catch (InstantiationException e) {
            throw new ServiceException("", e);
        } catch (IllegalAccessException e) {
            throw new ServiceException("", e);
        }
    }

    @Override
    @Transactional
    public <V extends BaseVo> Long create(V vo) {
        // 创建人ID
        if(vo.getCreateBy()==null){
            vo.setCreateBy(this.getLoginUserId());
        }
        // 创建时间
        vo.setCreateTime(DateUtil.getCurrentDate());
        // 更新者ID
        if(vo.getUpdateBy()==null){
            vo.setUpdateBy(this.getLoginUserId());
        }
        // 更新时间
        vo.setUpdateTime(DateUtil.getCurrentDate());

        // 逻辑删除标记
        vo.setIsDeleted(CommonConstants.IS_DELETED_FALSE);

        // 单表添加操作
        P po =  this.convert2Po(vo);
        this.getMapper().insert(po);
        return po.getId();
    }

    @Override
    @Transactional
    public <V extends BaseVo> Long createOrUpdate(V vo) {
        if (vo.getId() != null) {
            // 存在主键(ID)的情况下，更新非空字段
            this.dynamicUpdate(vo);
        } else {
            // 不存在主键(ID)的情况下，新增记录
            vo.setId(this.create(vo));
        }

        return vo.getId();
    }

    @Override
    @Transactional
    public <V extends BasePo> Integer dynamicUpdate(P po) {
        // 更新者ID
        if(po.getUpdateBy()==null){//避免venus接口已传调用更新
            po.setUpdateBy(this.getLoginUserId());
        }
        // 更新时间
        po.setUpdateTime(DateUtil.getCurrentDate());

        // 根据 @Id, 单表修改记录（更新实体对象中的非空字段）
        return this.getMapper().updateByPrimaryKeySelective(po);
    }

    @Override
    @Transactional
    public <V extends BaseVo> Integer dynamicUpdate(V vo) {
        // 更新者ID
        if(vo.getUpdateBy()==null){//避免venus接口已传调用更新
            vo.setUpdateBy(this.getLoginUserId());
        }
        // 更新时间
        vo.setUpdateTime(DateUtil.getCurrentDate());

        P po = this.convert2Po(vo);

        // 根据 @Id, 单表修改记录（更新实体对象中的非空字段）
        return this.getMapper().updateByPrimaryKeySelective(po);
    }

    @Override
    @Transactional
    public <V extends BaseVo> Integer dynamicUpdateWithOptimisticLock(V vo) {
        // 更新者ID
        if(vo.getUpdateBy()==null){//避免venus接口已传调用更新
            vo.setUpdateBy(this.getLoginUserId());
        }
        // 更新时间
        vo.setUpdateTime(DateUtil.getCurrentDate());
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",vo.getId());

        Field versionField = getAnnotationColumnName(PoClass,Version.class);
        if(versionField == null){
            throw new ServiceException(PoClass.getSimpleName()+"不存在version标识");
        }
        versionField.setAccessible(true);
        Long versionValue = 0L;
        Object value = null;
        try {
            value = versionField.get(PoClass);

        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage(),e);
            throw new ServiceException("获取parentId值错误："+e.getMessage());
        }
        if(value == null){
            throw new ServiceException(PoClass.getSimpleName()+"version value 为空");
        }
        versionValue = (Long)value;
        criteria.andEqualTo(versionField.getName(),(versionValue+1));

        P po = this.convert2Po(vo);
        Integer count = this.getMapper().updateByExampleSelective(po,example);
        if(count == 0){
            throw new ServiceException("更新失败，数据已更新");
        }

        return count;
    }

    private Field getAnnotationColumnName(Class<? extends Object> clazz, Class<? extends Annotation> annotationClazz){
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(annotationClazz)){
                return field;
            }
        }
        return null;

    }

    @Override
    public <V extends BaseVo> List<V> queryForList(V vo) {
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        vo.setIsDeleted(CommonConstants.IS_DELETED_FALSE);
        criteria.andEqualTo(vo);
        List<P> list = this.getMapper().selectByExample(example);
        List<V> vList = convert2Vo(list,vo.getClass());
        return vList;
    }

    @Override
    public <V extends BaseVo> List<V> queryByParentId(Long parentId,Class<? extends BaseVo> clazz) {
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        Field parentField = getAnnotationColumnName(PoClass,ParentId.class);
        if(parentField == null){
            throw new ServiceException(PoClass.getSimpleName()+"不存在@parentId注解");
        }
        parentField.setAccessible(true);
        Long parentIdValue = 0L;
        Object value = null;
        try {
            value = parentField.get(PoClass);

        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage(),e);
            throw new ServiceException("获取parentId值错误："+e.getMessage());
        }
        if(value == null){
            throw new ServiceException(PoClass.getSimpleName()+"version value 为空");
        }
        parentIdValue = (Long)value;
        criteria.andEqualTo(parentField.getName(),parentIdValue);
        criteria.andEqualTo("isDeleted",CommonConstants.IS_DELETED_FALSE);
        List<P> list = this.getMapper().selectByExample(example);
        List<V> vList = convert2Vo(list,clazz);
        return vList;
    }

    private <V extends BaseVo> List<V> convert2Vo(List<P> list,Class<? extends BaseVo> clazz){
        return list.stream().map(p -> {
            try {
                V v = (V) clazz.newInstance();
                BeanUtils.copyProperties(p,v);
                return v;
            } catch (Exception e) {
                LOGGER.error(e.getMessage(),e);
                throw new ServiceException("po转换vo异常："+e.getMessage());
            }
        }).collect(Collectors.toList());
    }

    @Override
    public <V extends BaseVo> PaginationResult<List<V>> queryForList(V vo,Example example,Pagination page) {
        if(example == null){
            example = new Example(PoClass);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo(vo);
        }
        List<V> vList = null;
        List<P> list = null;
        try {
            PaginationResult<List<V>> rtnPage =  new PaginationResult<>();
            int offset = page.getStart();
            int pageSize = page.getPagesize();
            int totalCount = 0;
            if(pageSize <= 0){
                list = this.getMapper().selectByExample(example);
                if(!CollectionUtils.isEmpty(list)){
                    totalCount = list.size();
                }
            }else{
                RowBounds bounds = new RowBounds(offset,pageSize);
                rtnPage.setPagination(page);
                totalCount = this.getMapper().selectCountByExample(example);
                if (totalCount > 0) {
                    list = this.getMapper().selectByExampleAndRowBounds(example,bounds);
                    if(CollectionUtils.isEmpty(list)){
                        return rtnPage;
                    }
                }
            }
            if(list != null){
                vList = convert2Vo(list,vo.getClass());
            }
            rtnPage.getPagination().setTotalRows(totalCount);
            rtnPage.setR(vList);
            return rtnPage;
        }catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public <V extends BaseVo> V findById(Long id,Class<V> requiredType) {
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        P po  = this.getMapper().selectOneByExample(example);
        V vo =  convert2Vo(po,requiredType);
        return vo;
    }

    /*
     * Po对象转换成Vo对象
     * @param vo Vo对象
     * @return Vo对象
     */
    private <V extends BaseVo> V convert2Vo(P po,Class<V> requiredType) {
        try {
            V vo = requiredType.newInstance();
            BeanUtils.copyProperties(po,vo);
            return vo;
        } catch (InstantiationException e) {
            throw new ServiceException("", e);
        } catch (IllegalAccessException e) {
            throw new ServiceException("", e);
        }
    }

    @Override
    public Integer removeByParentId(Long parentId) {
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        Field parentField = getAnnotationColumnName(PoClass,ParentId.class);
        if(parentField == null){
            throw new ServiceException(PoClass.getSimpleName()+"不存在@parentId注解");
        }
        parentField.setAccessible(true);
        Long parentIdValue = 0L;
        Object value = null;
        try {
            value = parentField.get(PoClass);

        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage(),e);
            throw new ServiceException("获取parentId值错误："+e.getMessage());
        }
        if(value == null){
            throw new ServiceException(PoClass.getSimpleName()+"version value 为空");
        }
        parentIdValue = (Long)value;
        criteria.andEqualTo(parentField.getName(),parentIdValue);
        Integer count = this.getMapper().deleteByExample(example);
        if(count == 0){
            throw new ServiceException("根据parentId删除数据失败");
        }
        return count;
    }

    @Override
    public Integer removeById(Long id) {
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        Integer count = this.getMapper().deleteByExample(example);
        return count;
    }

    @Override
    public <V extends BaseVo> V findByCondition(V vo, Class<V> requiredType) {
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(vo);
        P po  = this.getMapper().selectOneByExample(example);
        return convert2Vo(po,requiredType);
    }

    @Override
    public <V extends BaseVo> List<V> queryForList(P po, Class<V> requiredType) {
        Example example = new Example(PoClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(po);
        List<P> list = this.getMapper().selectByExample(example);
        List<V> vList = convert2Vo(list,requiredType);
        return vList;
    }
}

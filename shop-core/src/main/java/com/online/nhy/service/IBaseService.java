package com.online.nhy.service;

import com.online.nhy.baseMapper.CxBaseMapper;
import com.online.nhy.domain.BasePo;
import com.online.nhy.util.Pagination;
import com.online.nhy.util.PaginationResult;
import com.online.nhy.vo.BaseVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface IBaseService<P extends BasePo,Mapper extends CxBaseMapper<P>> {

    /**
     * 获取当前的Dal对象
     *
     * @return
     * @author zhangliang
     */
    CxBaseMapper<P> getMapper();

    Long getLoginUserId();

    /**
     * 根据VO实体对象，单表添加操作<BR>
     * 注意: VO属性必须与PO属性相同
     *
     * @param vo VO实体对象
     * @return 主键ID
     * @author zhangliang
     */
    <V extends BaseVo> Long create(V vo);

    /**
     * VO中的主键(ID)有值的情况下update（更新非空字段），否则create<BR>
     * 注意: VO属性必须与PO属性相同
     *
     * @param vo VO实体对象
     * @return 主键ID
     * @author zhangliang
     */
    <V extends BaseVo> Long createOrUpdate(V vo);

    /**
     * 根据po更新
     * @param po
     * @param <V>
     * @return
     */
    <V extends BasePo> Integer dynamicUpdate(P po);

    /**
     * 根据 @Id, 单表修改记录（更新实体对象中的非空字段）<BR>
     * 注意: VO属性必须与PO属性相同
     *
     * @param vo VO实体对象
     * @return 成功更新的记录条数
     * @author zhangliang
     */
    <V extends BaseVo> Integer dynamicUpdate(V vo);

    /**
     *  基于乐观锁机制更新(PO定义version属性和注解)
     * 根据 @Id, 单表修改记录（更新实体对象中的非空字段）<BR>
     * 注意: VO属性必须与PO属性相同
     *
     * @param vo VO实体对象
     * @return 成功更新的记录条数
     * @author zhangliang
     */
    <V extends BaseVo>  Integer dynamicUpdateWithOptimisticLock(V vo);

    /**
     * 根据实体VO中的非空条件查找<BR>
     * 注意: VO属性必须与PO属性相同
     *
     * @param vo 实体VO对象
     * @return 查找结果列表
     * @author dongzejun
     */
    <V extends BaseVo> List<V> queryForList(V vo);

    /**
     * 根据parentId查询
     * @param parentId
     * @param <V>
     * @return
     */
    <V extends BaseVo> List<V> queryByParentId(Long parentId, Class<? extends BaseVo> clazz);

    /**
     * 根据实体中的非空条件查找
     *
     * @param vo 实体VO对象
     * @param page 翻页信息
     * @return 查找结果列表
     */
    <V extends BaseVo> PaginationResult<List<V>> queryForList(V vo, Example example, Pagination page);

    /**
     * 根据Id查询
     * @param id
     * @param <V>
     * @return
     */
    <V extends BaseVo> V findById(Long id, Class<V> requiredType);

    /**
     * 根据 @ParentId 单表物理删除操作
     *
     * @param parentId 带有 @ParentId 声明的PO属性参数
     * @return 成功物理删除的记录数
     * @author dongzejun
     */
    Integer removeByParentId(Long parentId);

    /**
     * 根据 @Id 单表物理删除操作
     *
     * @param id 带有 @Id 声明的PO属性参数
     * @return 成功删除的记录数
     * @author dongzejun
     */
    Integer removeById(Long id);

    /**
     * 根据实体中的非空条件查找<BR>
     * 注意: VO属性必须与PO属性相同
     *
     * @param vo VO实体对象
     * @param requiredType 查找结果对象类型
     * @return 查找结果的首条记录
     * @author dongzejun
     */
    <V extends BaseVo> V findByCondition(V vo, Class<V> requiredType);

    /**
     * 根据实体VO中的非空条件查找<BR>
     * 注意: VO属性必须与PO属性相同
     *
     * @param vo 实体VO对象
     * @return 查找结果列表
     * @author dongzejun
     */
    <V extends BaseVo> List<V> queryForList(P po, Class<V> requiredType);

}

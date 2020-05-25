package com.online.nhy.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author NingHaiyang
 * @date 2020-01-10 9:57
 */
public class BaseVo implements java.io.Serializable {
    // serialVersionUID
    private static final long serialVersionUID = 6834473165049250202L;

    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    @ApiModelProperty(value = "创建人ID", required = false)
    private Long createBy;

    @ApiModelProperty(value = "创建时间 - create_time", required = false)
    private Date createTime;

    @ApiModelProperty(value = "更新人ID", required = false)
    private Long updateBy;

    @ApiModelProperty(value = "更新时间 - modify_time", required = false)
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除标记", required = false)
    private String isDeleted;

    // 查询页面的查询条件
    private String trackedQueryCondition = null;

    // 前画面URI
    private String prevRequestURI = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTrackedQueryCondition() {
        return trackedQueryCondition;
    }

    public void setTrackedQueryCondition(String trackedQueryCondition) {
        this.trackedQueryCondition = trackedQueryCondition;
    }

    public String getPrevRequestURI() {
        return prevRequestURI;
    }

    public void setPrevRequestURI(String prevRequestURI) {
        this.prevRequestURI = prevRequestURI;
    }
}

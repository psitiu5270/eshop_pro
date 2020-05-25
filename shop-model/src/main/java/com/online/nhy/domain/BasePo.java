package com.online.nhy.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class BasePo {

	private static final long serialVersionUID = 6581029953195073637L;

	@ApiModelProperty(value = "主键", required = true)
	/** 主键 */
	@Column(name = "id")
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	@ApiModelProperty(value = "创建人ID", required = true)
	/** 创建人ID */
	@Column(name = "create_by")
	private Long createBy;

	@ApiModelProperty(value = "创建时间 - create_time", required = false)
	/** 创建时间 - create_time */
	@Column(name = "create_time")
	private Date createTime;

	@ApiModelProperty(value = "更新人ID", required = true)
	/** 更新人ID */
	@Column(name = "update_by")
	private Long updateBy;

	@ApiModelProperty(value = "更新时间 - modify_time", required = false)
	/** 更新时间 - modify_time */
	@Column(name = "update_time")
	private Date updateTime;

	@ApiModelProperty(value = "逻辑删除标记", required = true)
	/** 逻辑删除标记 */
	@Column(name = "is_deleted")
	private String isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
}

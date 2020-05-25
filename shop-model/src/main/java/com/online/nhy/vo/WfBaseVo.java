package com.online.nhy.vo;

import com.online.nhy.domain.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 *
t_wf_base
 *
* @author NingHaiyang
* Mon May 25 10:44:14 CST 2020
 */
@ApiModel(value = "网发信息对象", parent = BasePagerVo.class)
public class WfBaseVo extends BasePagerVo {
    @ApiModelProperty(value = "门店编码 同org_no  -  store_code", required = true)
    @Column(name = "store_no")
    private String storeNo;

    @ApiModelProperty(value = "门店名称 同org_name - store_name", required = true)
    @Column(name = "store_name")
    private String storeName;

    @ApiModelProperty(value = "门店级别 A,B,C??保留后用", required = true)
    @Column(name = "store_level")
    private String storeLevel;

    @ApiModelProperty(value = "门店性质", required = true)
    @Column(name = "store_nature")
    private String storeNature;

    @ApiModelProperty(value = "供应商id", required = true)
    @Column(name = "vendor_id")
    private Long vendorId;

    @ApiModelProperty(value = "合作商名称(冗余)", required = true)
    @Column(name = "vendor_name")
    private String vendorName;

    @ApiModelProperty(value = "状态", required = true)
    @Column(name = "status")
    private String status;

    @ApiModelProperty(value = "网发状态", required = true)
    @Column(name = "wf_status")
    private String wfStatus;

    @ApiModelProperty(value = "商户", required = true)
    @Column(name = "merchant_id")
    private Long merchantId;

    @ApiModelProperty(value = "签约时间 - contact_time", required = true)
    @Column(name = "contact_time")
    private Date contactTime;

    @ApiModelProperty(value = "开店时间 - open_time", required = true)
    @Column(name = "open_time")
    private Date openTime;

    @ApiModelProperty(value = "店铺评分", required = true)
    @Column(name = "shop_score")
    private String shopScore;

    @ApiModelProperty(value = "归属类型 01.电商 02.直营店 03.维修站 04.加盟店", required = true)
    @Column(name = "owner_type")
    private String ownerType;

    @ApiModelProperty(value = "省ID- province_id 冗余查询用  t_region来源", required = true)
    @Column(name = "province_id")
    private Long provinceId;

    @ApiModelProperty(value = "市ID- city_id 冗余查询用", required = true)
    @Column(name = "city_id")
    private Long cityId;

    @ApiModelProperty(value = "省(冗余)", required = true)
    @Column(name = "province_name")
    private String provinceName;

    @ApiModelProperty(value = "城市(冗余)", required = true)
    @Column(name = "city_name")
    private String cityName;

    @ApiModelProperty(value = "门店详细地址 - store_address", required = true)
    @Column(name = "store_address")
    private String storeAddress;

    @ApiModelProperty(value = "工程id", required = true)
    @Column(name = "wf_project_id")
    private Long wfProjectId;

    @ApiModelProperty(value = "版本号", required = true)
    @Column(name = "version")
    private Long version;

    @ApiModelProperty(value = "备注", required = true)
    @Column(name = "remark")
    private String remark;

    @ApiModelProperty(value = "区县ID", required = true)
    @Column(name = "county_id")
    private Long countyId;

    @ApiModelProperty(value = "区县名称", required = true)
    @Column(name = "county_name")
    private String countyName;

    @ApiModelProperty(value = "建设类型", required = true)
    @Column(name = "construction_type")
    private String constructionType;

    @ApiModelProperty(value = "HR Id", required = true)
    @Column(name = "hr_id")
    private Long hrId;

    public WfBaseVo(){
        this.getPager().setPagesize(200);
    }
    /**

     */
    private static final long serialVersionUID = 1L;

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo == null ? null : storeNo.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreLevel() {
        return storeLevel;
    }

    public void setStoreLevel(String storeLevel) {
        this.storeLevel = storeLevel == null ? null : storeLevel.trim();
    }

    public String getStoreNature() {
        return storeNature;
    }

    public void setStoreNature(String storeNature) {
        this.storeNature = storeNature == null ? null : storeNature.trim();
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName == null ? null : vendorName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus == null ? null : wfStatus.trim();
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Date getContactTime() {
        return contactTime;
    }

    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getShopScore() {
        return shopScore;
    }

    public void setShopScore(String shopScore) {
        this.shopScore = shopScore == null ? null : shopScore.trim();
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType == null ? null : ownerType.trim();
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public Long getWfProjectId() {
        return wfProjectId;
    }

    public void setWfProjectId(Long wfProjectId) {
        this.wfProjectId = wfProjectId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType == null ? null : constructionType.trim();
    }

    public Long getHrId() {
        return hrId;
    }

    public void setHrId(Long hrId) {
        this.hrId = hrId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storeNo=").append(storeNo);
        sb.append(", storeName=").append(storeName);
        sb.append(", storeLevel=").append(storeLevel);
        sb.append(", storeNature=").append(storeNature);
        sb.append(", vendorId=").append(vendorId);
        sb.append(", vendorName=").append(vendorName);
        sb.append(", status=").append(status);
        sb.append(", wfStatus=").append(wfStatus);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", contactTime=").append(contactTime);
        sb.append(", openTime=").append(openTime);
        sb.append(", shopScore=").append(shopScore);
        sb.append(", ownerType=").append(ownerType);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", cityName=").append(cityName);
        sb.append(", storeAddress=").append(storeAddress);
        sb.append(", wfProjectId=").append(wfProjectId);
        sb.append(", version=").append(version);
        sb.append(", remark=").append(remark);
        sb.append(", countyId=").append(countyId);
        sb.append(", countyName=").append(countyName);
        sb.append(", constructionType=").append(constructionType);
        sb.append(", hrId=").append(hrId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
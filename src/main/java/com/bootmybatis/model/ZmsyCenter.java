package com.bootmybatis.model;

import java.util.Date;

public class ZmsyCenter {
    private Integer centerId;

    private String centername;

    private Integer addressId;

    private String companyname;

    private String centeraddress;

    private String linkman;

    private String linkphone;

    private String postalcode;

    private String email;

    private Integer centerIdParent;

    private Date createdate;

    private Integer examinecount;

    private Integer centeruserId;

    private Integer isfinishexamine;

    private Integer platformroleId;

    private Integer statusId;

    private Integer examineuserid;

    private Date examinedate;

    private Integer orderindex;

    private String centershortname;

    private String companynameManage;

    private String centeraddressManage;

    private String linkphoneManage;

    private String postalcodeManage;

    private String emailManage;

    private String weburlManage;

    private String linkmanManage;

    private String licenseManage;

    private Integer centerType;

    private String centerinfo;

    private String operateorgan;

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public String getCentername() {
        return centername;
    }

    public void setCentername(String centername) {
        this.centername = centername == null ? null : centername.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCenteraddress() {
        return centeraddress;
    }

    public void setCenteraddress(String centeraddress) {
        this.centeraddress = centeraddress == null ? null : centeraddress.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCenterIdParent() {
        return centerIdParent;
    }

    public void setCenterIdParent(Integer centerIdParent) {
        this.centerIdParent = centerIdParent;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getExaminecount() {
        return examinecount;
    }

    public void setExaminecount(Integer examinecount) {
        this.examinecount = examinecount;
    }

    public Integer getCenteruserId() {
        return centeruserId;
    }

    public void setCenteruserId(Integer centeruserId) {
        this.centeruserId = centeruserId;
    }

    public Integer getIsfinishexamine() {
        return isfinishexamine;
    }

    public void setIsfinishexamine(Integer isfinishexamine) {
        this.isfinishexamine = isfinishexamine;
    }

    public Integer getPlatformroleId() {
        return platformroleId;
    }

    public void setPlatformroleId(Integer platformroleId) {
        this.platformroleId = platformroleId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getExamineuserid() {
        return examineuserid;
    }

    public void setExamineuserid(Integer examineuserid) {
        this.examineuserid = examineuserid;
    }

    public Date getExaminedate() {
        return examinedate;
    }

    public void setExaminedate(Date examinedate) {
        this.examinedate = examinedate;
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    public String getCentershortname() {
        return centershortname;
    }

    public void setCentershortname(String centershortname) {
        this.centershortname = centershortname == null ? null : centershortname.trim();
    }

    public String getCompanynameManage() {
        return companynameManage;
    }

    public void setCompanynameManage(String companynameManage) {
        this.companynameManage = companynameManage == null ? null : companynameManage.trim();
    }

    public String getCenteraddressManage() {
        return centeraddressManage;
    }

    public void setCenteraddressManage(String centeraddressManage) {
        this.centeraddressManage = centeraddressManage == null ? null : centeraddressManage.trim();
    }

    public String getLinkphoneManage() {
        return linkphoneManage;
    }

    public void setLinkphoneManage(String linkphoneManage) {
        this.linkphoneManage = linkphoneManage == null ? null : linkphoneManage.trim();
    }

    public String getPostalcodeManage() {
        return postalcodeManage;
    }

    public void setPostalcodeManage(String postalcodeManage) {
        this.postalcodeManage = postalcodeManage == null ? null : postalcodeManage.trim();
    }

    public String getEmailManage() {
        return emailManage;
    }

    public void setEmailManage(String emailManage) {
        this.emailManage = emailManage == null ? null : emailManage.trim();
    }

    public String getWeburlManage() {
        return weburlManage;
    }

    public void setWeburlManage(String weburlManage) {
        this.weburlManage = weburlManage == null ? null : weburlManage.trim();
    }

    public String getLinkmanManage() {
        return linkmanManage;
    }

    public void setLinkmanManage(String linkmanManage) {
        this.linkmanManage = linkmanManage == null ? null : linkmanManage.trim();
    }

    public String getLicenseManage() {
        return licenseManage;
    }

    public void setLicenseManage(String licenseManage) {
        this.licenseManage = licenseManage == null ? null : licenseManage.trim();
    }

    public Integer getCenterType() {
        return centerType;
    }

    public void setCenterType(Integer centerType) {
        this.centerType = centerType;
    }

    public String getCenterinfo() {
        return centerinfo;
    }

    public void setCenterinfo(String centerinfo) {
        this.centerinfo = centerinfo == null ? null : centerinfo.trim();
    }

    public String getOperateorgan() {
        return operateorgan;
    }

    public void setOperateorgan(String operateorgan) {
        this.operateorgan = operateorgan == null ? null : operateorgan.trim();
    }
}
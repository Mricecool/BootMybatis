package com.bootmybatis.model;

import java.io.Serializable;
import java.util.Date;

public class ZmsyComplaint implements Serializable{

    private static final long serialVersionUID = -1164492971520375606L;

    private Integer complaintId;

    private String username;

    private String userphone;

    private String userqq;

    private String useremail;

    private Date complaintdate;

    private Integer centeruserId;

    private Integer status;

    private Date operatedate;

    private String complainttitle;

    private Integer source;

    private Integer complaintType;

    private Long complaintOrgId;

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUserqq() {
        return userqq;
    }

    public void setUserqq(String userqq) {
        this.userqq = userqq == null ? null : userqq.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public Date getComplaintdate() {
        return complaintdate;
    }

    public void setComplaintdate(Date complaintdate) {
        this.complaintdate = complaintdate;
    }

    public Integer getCenteruserId() {
        return centeruserId;
    }

    public void setCenteruserId(Integer centeruserId) {
        this.centeruserId = centeruserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }

    public String getComplainttitle() {
        return complainttitle;
    }

    public void setComplainttitle(String complainttitle) {
        this.complainttitle = complainttitle == null ? null : complainttitle.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(Integer complaintType) {
        this.complaintType = complaintType;
    }

    public Long getComplaintOrgId() {
        return complaintOrgId;
    }

    public void setComplaintOrgId(Long complaintOrgId) {
        this.complaintOrgId = complaintOrgId;
    }
}
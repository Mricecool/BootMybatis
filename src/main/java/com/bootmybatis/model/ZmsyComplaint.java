package com.bootmybatis.model;

import java.util.Date;

public class ZmsyComplaint {
    private Long complaintid;

    private Date complaintdate;

    private String title;

    private String content;

    private String addfile;

    private String name;

    private String tel;

    private String email;

    private Integer complainttype;

    private Integer status;

    private Long adminuserid;

    private Date opdate;

    private String opdesc;

    public Long getComplaintid() {
        return complaintid;
    }

    public void setComplaintid(Long complaintid) {
        this.complaintid = complaintid;
    }

    public Date getComplaintdate() {
        return complaintdate;
    }

    public void setComplaintdate(Date complaintdate) {
        this.complaintdate = complaintdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAddfile() {
        return addfile;
    }

    public void setAddfile(String addfile) {
        this.addfile = addfile == null ? null : addfile.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getComplainttype() {
        return complainttype;
    }

    public void setComplainttype(Integer complainttype) {
        this.complainttype = complainttype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAdminuserid() {
        return adminuserid;
    }

    public void setAdminuserid(Long adminuserid) {
        this.adminuserid = adminuserid;
    }

    public Date getOpdate() {
        return opdate;
    }

    public void setOpdate(Date opdate) {
        this.opdate = opdate;
    }

    public String getOpdesc() {
        return opdesc;
    }

    public void setOpdesc(String opdesc) {
        this.opdesc = opdesc == null ? null : opdesc.trim();
    }
}
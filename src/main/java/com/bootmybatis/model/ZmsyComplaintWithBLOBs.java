package com.bootmybatis.model;

public class ZmsyComplaintWithBLOBs extends ZmsyComplaint {
    private String complaintcontent;

    private String remarks;

    private String fileurl;

    private String fileoldname;

    public String getComplaintcontent() {
        return complaintcontent;
    }

    public void setComplaintcontent(String complaintcontent) {
        this.complaintcontent = complaintcontent == null ? null : complaintcontent.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getFileoldname() {
        return fileoldname;
    }

    public void setFileoldname(String fileoldname) {
        this.fileoldname = fileoldname == null ? null : fileoldname.trim();
    }
}
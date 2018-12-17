package com.bootmybatis.model;

public class ZmsyCenterWithBLOBs extends ZmsyCenter {
    private String weburl;

    private String examineremarks;

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl == null ? null : weburl.trim();
    }

    public String getExamineremarks() {
        return examineremarks;
    }

    public void setExamineremarks(String examineremarks) {
        this.examineremarks = examineremarks == null ? null : examineremarks.trim();
    }
}
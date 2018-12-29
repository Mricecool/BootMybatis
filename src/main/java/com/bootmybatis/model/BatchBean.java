package com.bootmybatis.model;

public class BatchBean {
    private String dataName;

    private String dataNo;

    private String dataPay;

    private String dataTime;

    private String dataCust;

    private String dataResult;

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getDataNo() {
        return dataNo;
    }

    public void setDataNo(String dataNo) {
        this.dataNo = dataNo == null ? null : dataNo.trim();
    }

    public String getDataPay() {
        return dataPay;
    }

    public void setDataPay(String dataPay) {
        this.dataPay = dataPay == null ? null : dataPay.trim();
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime == null ? null : dataTime.trim();
    }

    public String getDataCust() {
        return dataCust;
    }

    public void setDataCust(String dataCust) {
        this.dataCust = dataCust == null ? null : dataCust.trim();
    }

    public String getDataResult() {
        return dataResult;
    }

    public void setDataResult(String dataResult) {
        this.dataResult = dataResult == null ? null : dataResult.trim();
    }
}
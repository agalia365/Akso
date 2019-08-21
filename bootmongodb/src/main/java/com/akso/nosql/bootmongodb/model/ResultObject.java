package com.akso.nosql.bootmongodb.model;

public class ResultObject {

    private String status;
    private String errMsg;

    public ResultObject(String status, String errMsg) {
        this.status = status;
        this.errMsg = errMsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}

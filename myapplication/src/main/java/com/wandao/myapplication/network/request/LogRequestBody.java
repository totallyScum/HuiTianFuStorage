package com.wandao.myapplication.network.request;

import com.google.gson.annotations.SerializedName;

public class LogRequestBody {




//"accountPKId":"1",
//        "doorId":"2",
//        "status":"0",
//        "actionTime":"1575173301141",
//        "actionUserId":"1",
//        "remark":"理由"
    @SerializedName("accountPKId")
    public String accountPKId;
//    @SerializedName("LogID")
//    public String logID;
    @SerializedName("doorId")
    public String doorID;
    @SerializedName("status")
    public String status;
    @SerializedName("actionTime")
    public String actionTime;
    @SerializedName("actionUserId")
    public String actionUserId;
    @SerializedName("remark")
    public String remark;


    public String getAccountPKId() {
        return accountPKId;
    }

    public void setAccountPKId(String accountPKId) {
        this.accountPKId = accountPKId;
    }

    public String getDoorID() {
        return doorID;
    }

    public void setDoorID(String doorID) {
        this.doorID = doorID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionUserId() {
        return actionUserId;
    }

    public void setActionUserId(String actionUserId) {
        this.actionUserId = actionUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LogRequestBody{" +
                "accountPKId='" + accountPKId + '\'' +
                ", doorID='" + doorID + '\'' +
                ", status='" + status + '\'' +
                ", actionTime='" + actionTime + '\'' +
                ", actionUserId='" + actionUserId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

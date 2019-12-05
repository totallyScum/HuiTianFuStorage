package com.wandao.myapplication.network.response;

import android.widget.ProgressBar;

import com.google.gson.annotations.SerializedName;

public class SimpleResponse {
    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

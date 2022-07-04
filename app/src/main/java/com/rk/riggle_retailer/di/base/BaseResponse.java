package com.rk.riggle_retailer.di.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("code")
    String code;
    @SerializedName("message")
    String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}

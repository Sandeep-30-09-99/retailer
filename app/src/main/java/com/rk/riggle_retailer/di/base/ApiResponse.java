package com.rk.riggle_retailer.di.base;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> extends BaseResponse {

    @SerializedName("data")
    private T data;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

}

package com.rk.riggle_sales.utils.firebase;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jatin on 6/13/2017.
 */

public class NotificationPojo implements Serializable {

    /**
     * title : New Order Request
     * body : You have new order request
     * tag : 1
     * orderId : orderId
     */

    @SerializedName("title")
    public String title;
    @SerializedName("body")
    public String body;
    @SerializedName("tag")
    public String tag;
    @SerializedName("orderId")
    public String orderId;
}

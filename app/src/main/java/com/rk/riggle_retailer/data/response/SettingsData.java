package com.rk.riggle_retailer.data.response;

import androidx.annotation.LayoutRes;

public class SettingsData {

    @LayoutRes
    private int img;
    private String name;
    private String detail;

    public int getImg() {
        return img;
    }

    public SettingsData(@LayoutRes int img, String name, String detail) {
        this.img = img;
        this.name = name;
        this.detail = detail;
    }

    public void setImg(int img) {
        this.img = img;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

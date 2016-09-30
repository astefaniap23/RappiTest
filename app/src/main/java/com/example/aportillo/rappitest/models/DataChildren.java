package com.example.aportillo.rappitest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by aportillo on 27/09/2016.
 */
public class DataChildren implements Serializable {

    @SerializedName("display_name")
    private String displayName;
    @SerializedName("banner_img")
    private String bannerImg;
    @SerializedName("title")
    private String title;
    @SerializedName("header_title")
    private String headerTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("icon_img")
    private String iconImg;


    public DataChildren(String displayName, String bannerImg, String title, String headerTitle, String description,String iconImg) {
        this.displayName = displayName;
        this.bannerImg = bannerImg;
        this.title = title;
        this.headerTitle = headerTitle;
        this.description = description;
        this.iconImg = iconImg;

    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBannerImg() {
        return bannerImg;
    }


    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }
}


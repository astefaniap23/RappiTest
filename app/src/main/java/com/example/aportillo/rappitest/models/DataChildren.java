package com.example.aportillo.rappitest.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aportillo on 27/09/2016.
 */
public class DataChildren {

    @SerializedName("display_name")
    private String displayName;
    @SerializedName("icon_img")
    private String iconImg;
    @SerializedName("title")
    private String title;
    @SerializedName("header_title")
    private String headerTitle;
    @SerializedName("description")
    private String description;

    public DataChildren(String displayName, String iconImg, String title, String headerTitle, String description) {
        this.displayName = displayName;
        this.iconImg = iconImg;
        this.title = title;
        this.headerTitle = headerTitle;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIconImg() {
        return iconImg;
    }

    public Bitmap getIconImgBitMap() {
        byte[] decodedString = Base64.decode(getIconImg(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }


    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
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
}


package com.example.aportillo.rappitest.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aportillo on 27/09/2016.
 */
public class Data {

    @SerializedName("modhash")
    private String modhash;
    @SerializedName("children")
    private ArrayList<Children> childrenList;
    @SerializedName("after")
    private String after;
    @SerializedName("before")
    private String before;

    public Data(String modhash, ArrayList<Children> childrenList, String after, String before) {
        this.modhash = modhash;
        this.childrenList = childrenList;
        this.after = after;
        this.before = before;
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public ArrayList<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(ArrayList<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }
}

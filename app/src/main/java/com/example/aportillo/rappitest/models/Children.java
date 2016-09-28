package com.example.aportillo.rappitest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by aportillo on 27/09/2016.
 */
public class Children implements Serializable {

    @SerializedName("kind")
    private String kind;
    @SerializedName("data")
    private DataChildren dataChildrenList;

    public Children(String kind, DataChildren dataChildrenList) {
        this.kind = kind;
        this.dataChildrenList = dataChildrenList;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public DataChildren getDataChildrenList() {
        return dataChildrenList;
    }

    public void setDataChildrenList(DataChildren dataChildrenList) {
        this.dataChildrenList = dataChildrenList;
    }
}


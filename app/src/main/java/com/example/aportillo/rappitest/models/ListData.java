package com.example.aportillo.rappitest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aportillo on 27/09/2016.
 */
public class ListData {

    @SerializedName("kind")
    private String kind;
    @SerializedName("data")
    private Data data;

    public ListData(String kind, Data data) {
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

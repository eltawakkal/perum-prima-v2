package com.example.mycontact.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cicilan {

    @SerializedName("total_cicilan")
    private String totalCicilan;
    @SerializedName("data")
    private List<ListCicilan> listCicilan;

    public Cicilan(String totalCicilan, List<ListCicilan> listCicilan) {
        this.totalCicilan = totalCicilan;
        this.listCicilan = listCicilan;
    }

    public String getTotalCicilan() {
        return totalCicilan;
    }

    public List<ListCicilan> getListCicilan() {
        return listCicilan;
    }
}

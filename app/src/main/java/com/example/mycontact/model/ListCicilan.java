package com.example.mycontact.model;

public class ListCicilan {

    private String id;
    private String cicilan;
    private String date;
    private String status;
    private String type;

    public ListCicilan() {
    }

    public ListCicilan(String id, String cicilan, String date, String status, String type) {
        this.id = id;
        this.cicilan = cicilan;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getCicilan() {
        return cicilan;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }
}

package com.example.mycontact.model;

public class Tagihan {

    private String id;
    private String nama;
    private String no_telp;
    private String unit;
    private String type;

    public Tagihan() {
    }

    public Tagihan(String id, String nama, String no_telp, String unit, String type) {
        this.id = id;
        this.nama = nama;
        this.no_telp = no_telp;
        this.unit = unit;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getUnit() {
        return unit;
    }

    public String getType() {
        return type;
    }
}

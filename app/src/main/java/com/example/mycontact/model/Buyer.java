package com.example.mycontact.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Buyer implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("unit")
    private String unit;
    @SerializedName("nama")
    private String nama;
    @SerializedName("house_id")
    private String houseId;
    @SerializedName("no_telp")
    private String noTelp;
    @SerializedName("no_pasangan")
    private String no_pasangan;
    @SerializedName("no_darurat")
    private String no_darurat;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("pekerjaan")
    private String pekerjaan;
    @SerializedName("status_berkas")
    private String status_berkas;
    @SerializedName("tgl_booking")
    private String tgl_booking;
    @SerializedName("bank_pel")
    private String bank_pel;
    @SerializedName("ket")
    private String ket;
    @SerializedName("a")
    private String a;
    @SerializedName("b")
    private String b;
    @SerializedName("c")
    private String c;
    @SerializedName("d")
    private String d;
    @SerializedName("e")
    private String e;
    @SerializedName("f")
    private String f;
    @SerializedName("g")
    private String g;
//    @SerializedName("bayarfee")
//    private String bayarfee;
//    @SerializedName("bayar1")
//    private String bayar1;
//    @SerializedName("bayar2")
//    private String bayar2;
//    @SerializedName("bayar3")
//    private String bayar3;
//    @SerializedName("bayar4")
//    private String bayar4;
//    @SerializedName("total_pembayaran")
//    private String total_pembayaran;
    @SerializedName("verified")
    private String verified;

    public Buyer(String id, String unit, String nama, String houseId, String noTelp, String no_pasangan,
                 String no_darurat, String alamat, String pekerjaan, String status_berkas, String tgl_booking, String bank_pel,
                 String ket, String a, String b, String c, String d, String e, String f, String g, String verified) {
        this.id = id;
        this.unit = unit;
        this.nama = nama;
        this.houseId = houseId;
        this.noTelp = noTelp;
        this.no_pasangan = no_pasangan;
        this.no_darurat = no_darurat;
        this.alamat = alamat;
        this.pekerjaan = pekerjaan;
        this.status_berkas = status_berkas;
        this.tgl_booking = tgl_booking;
        this.bank_pel = bank_pel;
        this.ket = ket;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
//        this.bayarfee = bayarfee;
//        this.bayar1 = bayar1;
//        this.bayar2 = bayar2;
//        this.bayar3 = bayar3;
//        this.bayar4 = bayar4;
//        this.total_pembayaran = total_pembayaran;
        this.verified = verified;
    }

    protected Buyer(Parcel in) {
        id = in.readString();
        unit = in.readString();
        nama = in.readString();
        houseId = in.readString();
        noTelp = in.readString();
        no_pasangan = in.readString();
        no_darurat = in.readString();
        alamat = in.readString();
        pekerjaan = in.readString();
        status_berkas = in.readString();
        tgl_booking = in.readString();
        bank_pel = in.readString();
        ket = in.readString();
        a = in.readString();
        b = in.readString();
        c = in.readString();
        d = in.readString();
        e = in.readString();
        f = in.readString();
        g = in.readString();
//        bayarfee = in.readString();
//        bayar1 = in.readString();
//        bayar2 = in.readString();
//        bayar3 = in.readString();
//        bayar4 = in.readString();
//        total_pembayaran = in.readString();
        verified = in.readString();
    }

    public static final Creator<Buyer> CREATOR = new Creator<Buyer>() {
        @Override
        public Buyer createFromParcel(Parcel in) {
            return new Buyer(in);
        }

        @Override
        public Buyer[] newArray(int size) {
            return new Buyer[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public String getNama() {
        return nama;
    }

    public String getHouseId() {
        return houseId;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getno_pasangan() {
        return no_pasangan;
    }

    public String getno_darurat() {
        return no_darurat;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public String getstatus_berkas() {
        return status_berkas;
    }

    public String gettgl_booking() {
        return tgl_booking;
    }

    public String getbank_pel() {
        return bank_pel;
    }

    public String getKet() {
        return ket;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getE() {
        return e;
    }

    public String getF() {
        return f;
    }

    public String getG() {
        return g;
    }

//    public String getBayarfee() {
//        return bayarfee;
//    }
//
//    public String getBayar1() {
//        return bayar1;
//    }
//
//    public String getBayar2() {
//        return bayar2;
//    }
//
//    public String getBayar3() {
//        return bayar3;
//    }
//
//    public String getBayar4() {
//        return bayar4;
//    }
//
//    public String getTotal_pembayaran() {
//        return total_pembayaran;
//    }

    public String getVerified() {
        return verified;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(unit);
        dest.writeString(nama);
        dest.writeString(houseId);
        dest.writeString(noTelp);
        dest.writeString(no_pasangan);
        dest.writeString(no_darurat);
        dest.writeString(alamat);
        dest.writeString(pekerjaan);
        dest.writeString(status_berkas);
        dest.writeString(tgl_booking);
        dest.writeString(bank_pel);
        dest.writeString(ket);
        dest.writeString(a);
        dest.writeString(b);
        dest.writeString(c);
        dest.writeString(d);
        dest.writeString(e);
        dest.writeString(f);
        dest.writeString(g);
//        dest.writeString(bayarfee);
//        dest.writeString(bayar1);
//        dest.writeString(bayar2);
//        dest.writeString(bayar3);
//        dest.writeString(bayar4);
//        dest.writeString(total_pembayaran);
        dest.writeString(verified);
    }
}

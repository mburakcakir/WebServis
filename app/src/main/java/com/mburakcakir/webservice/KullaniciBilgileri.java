package com.mburakcakir.webservice;

import com.google.gson.annotations.SerializedName;

public class KullaniciBilgileri {

    @SerializedName("userId")
    private int kullaniciID;
    @SerializedName("id")
    private int siralamaNo;
    @SerializedName("title")
    private String baslik;
    @SerializedName("body")
    private String paragraf;

    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public int getSiralamaNo() {
        return siralamaNo;
    }

    public void setSiralamaNo(int siralamaNo) {
        this.siralamaNo = siralamaNo;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getParagraf() {
        return paragraf;
    }

    public void setParagraf(String paragraf) {
        this.paragraf = paragraf;
    }
}

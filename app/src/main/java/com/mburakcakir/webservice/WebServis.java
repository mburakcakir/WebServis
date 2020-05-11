package com.mburakcakir.webservice;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServis {

    String link = "https://jsonplaceholder.typicode.com/";
    Retrofit retrofit;
    ServisMetodlari servisMetodlari;

    Retrofit retrotifiGetir() {
        retrofit = new Retrofit.Builder()
                .baseUrl(link)
                .client(new OkHttpClient().newBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public ServisMetodlari servisMetodunuGetir() {
        servisMetodlari = retrotifiGetir().create(ServisMetodlari.class);
        return servisMetodlari;
    }
}

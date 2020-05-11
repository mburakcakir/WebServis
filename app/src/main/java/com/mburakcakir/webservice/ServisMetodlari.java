package com.mburakcakir.webservice;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServisMetodlari {

    @GET("posts")
    Observable<List<KullaniciBilgileri>> kullanicilariGetir();
}

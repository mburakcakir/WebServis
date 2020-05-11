package com.mburakcakir.webservice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<KullaniciBilgileri> kullaniciBilgileriList = new ArrayList<>();
    Button volley, retrofit2, temizle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        volley = findViewById(R.id.volley);
        retrofit2 = findViewById(R.id.retrofit2);
        temizle = findViewById(R.id.temizle);

        volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kullaniciListesiniGetirVolley();
            }
        });

        retrofit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kullaniciListesiniGetirRetrofit2();
            }
        });

        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kullaniciBilgileriList.clear();
                recyclerViewCagir(kullaniciBilgileriList);
            }
        });
    }

    void kullaniciListesiniGetirRetrofit2() {

        new WebServis().servisMetodunuGetir().kullanicilariGetir()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KullaniciBilgileri>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<KullaniciBilgileri> kullaniciBilgileris) {
                        kullaniciBilgileriList = kullaniciBilgileris;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (kullaniciBilgileriList.size() > 0) {
                            recyclerViewCagir(kullaniciBilgileriList);
                        }

                    }
                });
    }

    void kullaniciListesiniGetirVolley() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                KullaniciBilgileri[] kullaniciBilgileris = gson.fromJson(response, KullaniciBilgileri[].class);
                List<KullaniciBilgileri> kullaniciBilgileriList = Arrays.asList(kullaniciBilgileris);
                recyclerViewCagir(kullaniciBilgileriList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }

    void recyclerViewCagir(List<KullaniciBilgileri> kullaniciBilgileri) {
        KullaniciAdapter adapter = new KullaniciAdapter(kullaniciBilgileri);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}

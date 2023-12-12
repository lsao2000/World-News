package com.example.worldnews.data.retrofitApi;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * GetRetro
 */
public class GetRetro {
    public static final String BASE_URL = "https://newsapi.org/v2/";
    public static Retrofit retro = null;
    public static Retrofit getRetrofit(){
        if(retro == null){
           retro = new Retrofit.Builder().baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
        }
        return retro;
    };
}

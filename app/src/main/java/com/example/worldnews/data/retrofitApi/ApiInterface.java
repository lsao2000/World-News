package com.example.worldnews.data.retrofitApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * ApiInterface
 */
public interface ApiInterface {
    

    @GET("everything?q=a&apiKey="+KeyApi.API_KEY)
    Call<NewsObject> getArticles();
    
    @GET("top-headlines?category=sports&apiKey="+KeyApi.API_KEY)
    Call<NewsObject> getSportArticle();

    @GET("top-headlines?category=technology&apiKey="+KeyApi.API_KEY)
    Call<NewsObject> getTechnologyArticle();

    @GET("top-headlines?category=entertainment&apiKey="+KeyApi.API_KEY)
    Call<NewsObject> getEntertainmentArticle();
    @GET("top-headlines?category=science&apiKey="+KeyApi.API_KEY)
    Call<NewsObject> getScinceArticle();

    @GET("top-headlines?category=health&apiKey="+KeyApi.API_KEY)
    Call<NewsObject> getHealthArticle();

}

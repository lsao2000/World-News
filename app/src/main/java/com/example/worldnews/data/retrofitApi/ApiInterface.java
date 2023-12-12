package com.example.worldnews.data.retrofitApi;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * ApiInterface
 */
public interface ApiInterface {
    

    @GET("everything?q=a&apiKey="+KeyApi.API_KEY)
    Call<NewsObject> getArticles();

}

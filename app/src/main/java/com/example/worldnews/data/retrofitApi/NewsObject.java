package com.example.worldnews.data.retrofitApi;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * NewsObject
 */
public class NewsObject {

    private String status;
    @SerializedName("totalResults")
    private int results;
    private List<GetArticles> articles;


    public String getStatus(){
        return status;
    }
    public int getResults(){
        return results;
    }
    public List<GetArticles> getArticles(){
        return articles;
    }

}

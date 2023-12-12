package com.example.worldnews.data.retrofitApi;
import java.util.HashMap;
import com.google.gson.annotations.SerializedName;
/**
 * GetArticles
 */
public class GetArticles {
    private SourceObject source;
    private String title;
    private String description;
    @SerializedName("url")
    private String urlPage;
    @SerializedName("urlToImage")
    private String urlImage;
    @SerializedName("publishedAt")
    private String dateNews;
    private String author;
    public String getAuthor(){
        return author;
    }

    public SourceObject getSource(){
        return source;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getUrlPage(){
        return urlPage;
    }
    public String getUrlImage(){
        return urlImage;
    }
    public String getDateNews(){
        return dateNews;
    }


}

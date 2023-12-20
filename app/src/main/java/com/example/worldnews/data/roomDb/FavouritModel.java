package com.example.worldnews.data.roomDb;

import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.Entity;
import java.time.LocalDate;
/**
 * FavouritModel
 */
@Entity(tableName="favourite_table")
public class FavouritModel {
    
    @ColumnInfo(name = "favoriteId");
    @PrimaryKey(autoGenerate=true)
    private int id;

    @ColumnInfo(name="source")
    private String source;
    @ColumnInfo(name="title")
    private String title;
    @ColumnInfo(name="date")
    private LocalDate date;
    @ColumnInfo(name="details")
    private String details;
    @ColumnInfo(name="author")
    private String author;
    @ColumnInfo(name="imgUrl")
    private String urlImage;
    @ColumnInfo(name="UrlSource")
    private String UrlSource;
    @ColumnInfo(name="typeNews")
    private String type;

    public FavouritModel(String source, String title, LocalDate date, String details, String author, String urlImage, String UrlSource, String type){
        this.title = title;
        this.source = source;
        this.date = date;
        this.details = details;
        this.author = author;
        this.urlImage = urlImage;
        this.UrlSource = UrlSource;
        this.type = type;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return source;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDetails(String details){
        this.details = details;
    }
    public String getDetails(){
        return details;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    public void setUrlImage(String urlImage){
        this.urlImage = urlImage;
    }
    public String getUrlImage(){
        return urlImage;
    }
    public void setUrlSource(String UrlSource){
        this.UrlSource = UrlSource;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
}

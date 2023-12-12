package com.example.worldnews.data.retrofitApi;


/**
 * SourceObject
 */
public class SourceObject {

    private String id;
    private String name;
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
}

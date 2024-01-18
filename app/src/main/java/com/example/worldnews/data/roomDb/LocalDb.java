package com.example.worldnews.data.roomDb;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.Room;

/**
 * LocalDb
 */
public abstract class LocalDb extends RoomDatabase{
    private static volatile LocalDb localDbInstance;

    public static synchronized LocalDb getInstance(Context context){
        if(localDbInstance == null){
            localDbInstance = Room.databaseBuilder(context.getApplicationContext(), LocalDb.class, "localdb_user")
                .allowMainThreadQueries()
                .build();
        } 
        return localDbInstance;
    }
       
}

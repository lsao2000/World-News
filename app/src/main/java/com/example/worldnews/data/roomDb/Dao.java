package com.example.worldnews.data.roomDb;

import androidx.room.Insert;
import androidx.room.Delete;
import androidx.room.Update;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;
import java.util.List;
/**
 * Dao
 */
@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) 
    void insertFavorite(FavouriteModel... favoriteNews);
    
    @Query("SELECT FROM favourite_table");
    List<FavouriteModel> getAllFavourite();

    @Delete("Delete FROM favourite_table WHERE favoriteId = :favorId")
    void DeleteFavorite(int favorId);

}

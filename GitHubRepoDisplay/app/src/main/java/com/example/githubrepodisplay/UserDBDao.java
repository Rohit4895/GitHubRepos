package com.example.githubrepodisplay;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDBDao {
    @Insert
    long insert(UserDB userDB);

    @Query("DELETE FROM UserDB")
    void deleteAll();

    @Update
    int update(UserDB userDB);

    @Query("select * from UserDB")
    List<Items> getAll();
}

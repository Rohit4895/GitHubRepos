package com.example.githubrepodisplay;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {UserDB.class},version = 1)
public abstract class UserDBDatabase extends RoomDatabase {
    public abstract UserDBDao userDBDao();
}

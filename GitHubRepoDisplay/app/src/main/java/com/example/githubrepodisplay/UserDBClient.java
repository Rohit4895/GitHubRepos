package com.example.githubrepodisplay;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public class UserDBClient {
    private Context context;
    private static UserDBClient userDBClientInstancs;
    private UserDBDatabase userDBDatabase;

    public UserDBClient(Context context) {
        this.context = context;
        userDBDatabase = Room.databaseBuilder(context,UserDBDatabase.class,"User Database").build();
    }

    public static synchronized UserDBClient getInstance(Context context){
        if (userDBClientInstancs == null){
            userDBClientInstancs = new UserDBClient(context);
        }
        return userDBClientInstancs;
    }

    public UserDBDatabase getUserDBDatabase(){
        return userDBDatabase;
    }
}

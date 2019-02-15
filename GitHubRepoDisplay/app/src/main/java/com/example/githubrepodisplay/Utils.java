package com.example.githubrepodisplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class Utils {
    private static int sTheme;

    public static final int THEME_DEFAULT = 0;
    public static final int THEME_BLACK = 1;

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void changeTheme(Activity activity, int theme){
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity,activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity){
        switch (sTheme){

            case THEME_BLACK:
                activity.setTheme(R.style.BlackTheme);
                sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("status",1);
                editor.commit();
                break;

            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("status",2);
                editor.commit();
                break;
        }
    }
}

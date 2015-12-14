package com.example.simpleui;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by caca on 2015/12/14.
 */
public class SimpleUiApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this);

    }

}

package com.ehsy.lua.demo.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Lua on 2015/12/22 9:52.
 */
public class App extends Application {
    private static RequestQueue queue;
    @Override
    public void onCreate() {
        super.onCreate();
        queue= Volley.newRequestQueue(this);
    }

    public static RequestQueue getQueue() {
        return queue;
    }
}

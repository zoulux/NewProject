package com.ehsy.lua.newhttp.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Lua on 2015/12/22 15:19.
 */
public class App extends Application {
    private static RequestQueue mQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getQueue() {
        return mQueue;
    }
}

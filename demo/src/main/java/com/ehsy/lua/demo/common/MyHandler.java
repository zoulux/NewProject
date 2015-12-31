package com.ehsy.lua.demo.common;

/**
 * Created by Lua on 2015/12/17 15:48.
 */
public class MyHandler  {
    private HttpListener listener;
    public MyHandler(HttpListener listener) {
        this.listener= listener;

    }

    public HttpListener getListener() {
        return listener;
    }
}

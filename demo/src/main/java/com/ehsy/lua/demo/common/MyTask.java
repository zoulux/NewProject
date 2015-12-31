package com.ehsy.lua.demo.common;

import com.ehsy.lua.demo.model.HttpParameters;
import com.ehsy.lua.demo.utils.DialogUtils;
import com.ehsy.lua.demo.utils.VolleyUtils;

/**
 * Created by Lua on 2015/12/17 15:52.
 */
public class MyTask  {
    private static final String TAG = "MyTask";

    private HttpParameters params;
    private MyHandler handler;
    public MyTask(HttpParameters params, MyHandler handle) {
        this.params=params;
        this.handler= handle;

    }

    public void go() {
        if (params.context!=null)
        DialogUtils.show(params.context);
        VolleyUtils.request(params, handler.getListener());

    }

}

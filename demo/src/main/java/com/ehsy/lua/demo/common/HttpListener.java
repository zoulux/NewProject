package com.ehsy.lua.demo.common;

import com.ehsy.lua.demo.model.HttpParameters;

/**
 * Created by Lua on 2015/12/22 14:43.
 */
public interface HttpListener {
    public void success(HttpParameters successResult);

    public void faild(HttpParameters err);
}

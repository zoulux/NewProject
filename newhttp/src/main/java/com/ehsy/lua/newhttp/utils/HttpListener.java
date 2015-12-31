package com.ehsy.lua.newhttp.utils;

import com.ehsy.lua.newhttp.model.HttpParameters;

/**
 * Created by Lua on 2015/12/22 16:25.
 */
public interface HttpListener {
    void success(HttpParameters successResult);
    void faild(HttpParameters errorResult);
}

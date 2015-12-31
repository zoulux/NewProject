package com.ehsy.lua.betterhttp.view;


import com.ehsy.lua.betterhttp.model.HttpParameters;

/**
 * Created by Lua on 2015/12/22 15:14.
 */
public interface HttpListener {
    void success(HttpParameters successReult);
    void faild(HttpParameters errResult);
}

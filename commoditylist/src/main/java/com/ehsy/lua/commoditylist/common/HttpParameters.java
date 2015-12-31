package com.ehsy.lua.commoditylist.common;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lua on 2015/12/22 15:02.
 */
public class HttpParameters {
    public enum Method {
        GET, POST
    }

    public Context context;//上下文
    public String appHost= Config.APP_HOST; //主机地址
    public Map<String, String> params=new HashMap<>(); //参数
    public Method method = Method.POST;
    public String result;  //返回的结果
    public int responseCode; //返回码
    public  boolean hasDialog=true; //进度框

    public void addParameter(String key,String value){
        params.put(key,value);
    }
}

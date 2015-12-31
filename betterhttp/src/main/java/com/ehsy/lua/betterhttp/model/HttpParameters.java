package com.ehsy.lua.betterhttp.model;

import android.content.Context;

import java.util.Map;

/**
 * Created by Lua on 2015/12/22 15:02.
 */
public class HttpParameters {
    private static  final String DEFAULT_HOST="http://app.ehsy.cn/v20151127/index.php";

    public enum Method {
        GET, POST
    }

    public Context context;//上下文
    public String appHost=DEFAULT_HOST; //主机地址
    public Map<String, String> params; //参数
    public Method method = Method.POST;
    public String result;  //返回的结果
    public int responseCode; //返回码
    public  boolean hasDialog=true; //进度框
}

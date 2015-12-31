package com.ehsy.lua.commoditylist.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ehsy.lua.commoditylist.application.App;
import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;

import java.util.Map;

/**
 * Created by Lua on 2015/12/22 9:33.
 */
public class VolleyUtils {

    private static final String TAG = "VolleyUtils";
    private Context context;
    private static HttpListener listener;
    private static HttpParameters parameters;


    private static StringRequest post() {
        StringRequest sr = new StringRequest(Request.Method.POST, parameters.appHost, successListener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return parameters.params;
            }
        };
        return sr;
    }

    private static StringRequest get() {
        StringRequest sr = new StringRequest(Request.Method.GET, parameters.appHost + "?" + CommonUtils.map2String(parameters.params), successListener, errorListener);
        return sr;
    }


    public static void request(HttpParameters parameters, HttpListener listener) {
        VolleyUtils.listener = listener;
        VolleyUtils.parameters = parameters;
        StringRequest sr = null;
        if (parameters.method == HttpParameters.Method.GET) {
            sr = get();
        } else if (parameters.method == HttpParameters.Method.POST) {
            sr = post();
        }
        if (sr!=null)
            App.getQueue().add(sr);
    }

    static Response.Listener successListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            parameters.result = response;
            parameters.responseCode = 200;
            if (listener != null)
                listener.success(parameters);
        }
    };

    static Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            parameters.result = error.toString();
            Log.d(TAG, "onErrorResponse :" + error.toString());
            parameters.responseCode = 400;
            if (listener != null)
                listener.faild(parameters);
        }
    };
}

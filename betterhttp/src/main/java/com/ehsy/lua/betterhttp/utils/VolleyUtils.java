package com.ehsy.lua.betterhttp.utils;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ehsy.lua.betterhttp.application.App;
import com.ehsy.lua.betterhttp.model.HttpParameters;
import com.ehsy.lua.betterhttp.view.HttpListener;

import java.util.Map;

/**
 * Created by Lua on 2015/12/22 9:33.
 */
public class VolleyUtils {

    private Context context;
    private static HttpListener listener;


    public static void post(final HttpParameters parameters) {
        StringRequest jr = new StringRequest(Request.Method.POST, parameters.appHost, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parameters.result = response;
                parameters.responseCode = 200;

                listener.success(parameters);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                parameters.result = error.toString();
                parameters.responseCode = error.networkResponse.statusCode;
                listener.faild(parameters);

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return parameters.params;
            }
        };
        App.getQueue().add(jr);

    }

    public static void get(final HttpParameters parameters) {
        StringRequest jr = new StringRequest(Request.Method.GET, parameters.appHost + "?" + CommonUtils.map2String(parameters.params), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parameters.result = response;
                parameters.responseCode = 200;
                listener.success(parameters);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                parameters.result = error.toString();
                parameters.responseCode = error.networkResponse.statusCode;
                listener.faild(parameters);

            }
        });
        App.getQueue().add(jr);
    }


    public static void request(HttpParameters parameters, HttpListener listener) {
        VolleyUtils.listener = listener;
        if (parameters.method == HttpParameters.Method.GET) {
            get(parameters);
        } else if (parameters.method == HttpParameters.Method.POST) {
            post(parameters);
        }
    }
}

package com.ehsy.lua.demo.utils;

import android.util.Log;

import com.ehsy.lua.demo.model.HttpParameters;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lua on 2015/12/17 15:45.
 */
public class HttpUtils {
    private static final String TAG = "HttpUtils";

    public static final int CONNECT_TIME = 5000;
    private static HttpParameters params;

    public static final int SUCCESS = 0x110;
    public static final int FAILD = 0x111;


    public static HttpParameters request(HttpParameters params) {
        HttpUtils.params = params;
        switch (params.method) {
            case GET:
                httpGet();
                break;
            case POST:
                httpPost();
                break;
        }
        return params;
    }

    private static void httpPost() {
        int responseCode = 0;
        String content = "";
        HttpURLConnection con = null;

        try {
            URL url = new URL(params.appHost);
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setConnectTimeout(CONNECT_TIME);
            con.connect();


            OutputStream os = con.getOutputStream();  //获取connection所对应的输出流
            os.write(CommonUtils.string2Byte(CommonUtils.map2String(params.params))); //将参数写进输出流
            os.flush();//刷新输出流
            os.close();

            responseCode = con.getResponseCode();
            content = CommonUtils.inputStream2String(con.getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.disconnect();
        }

        params.responseCode = responseCode;
        params.result = content;

    }

    private static void httpGet() {

        int responseCode = 0;
        String content = "";

        try {
            URL url = new URL(params.appHost + "?" + CommonUtils.map2String(params.params));
            Log.d(TAG, "httpGet 请求网址："+params.appHost + "?" + CommonUtils.map2String(params.params));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(CONNECT_TIME);
            con.setRequestMethod("GET");
            con.connect();

            content = CommonUtils.inputStream2String(con.getInputStream());
            responseCode = con.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        params.result = content;
        params.responseCode = responseCode;
    }
}

package com.ehsy.lua.commoditylist.utils;

import com.ehsy.lua.commoditylist.common.HttpParameters;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by Lua on 2015/12/17 16:04.
 */
public class CommonUtils {
    private static final String TAG = "CommonUtils";


    public static String map2String(Map<String,String> map)  {
        StringBuilder result=new StringBuilder();

        if (map==null||map.size()==0)
            return "";

        for (String key : map.keySet()) {
            result.append(key).append("=").append(map.get(key)).append("&");
        }
       return result.substring(0,result.length()-1);
    }
    
    
    
    public static String inputStream2String(InputStream stream) throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line=br.readLine())!=null){
            sb.append("\n").append(line);
        }
        return sb.toString();
    }

    public static byte[] string2Byte(String s)  {
        return s.getBytes();
    }


    public static String parameterGetResult(HttpParameters parameters,String info){
        String result="";
        try {
            JSONObject jsonObject=new JSONObject(parameters.result);
            result  =jsonObject.getString(info);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}

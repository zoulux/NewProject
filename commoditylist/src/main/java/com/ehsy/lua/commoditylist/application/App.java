package com.ehsy.lua.commoditylist.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ehsy.lua.commoditylist.model.Product;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lua on 2015/12/24 11:35.
 */
public class App extends Application {
    private static RequestQueue queue;
    private static Map<Product, Integer> buyCar;

    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(this);  //初始化Volley
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this)); // 配置imageloader
        buyCar = new HashMap<>(); //创建购物车
    }

    public static RequestQueue getQueue() {
        return queue;
    }

    public static Map<Product, Integer> getBuyCar() {
        return buyCar;
    }
}

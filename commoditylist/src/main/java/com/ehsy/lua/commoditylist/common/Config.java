package com.ehsy.lua.commoditylist.common;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Created by Lua on 2015/12/24 14:52.
 */
public class Config {
    public static final String APP_PIC_HOST = "http://image.ehsy.com/";
    public static final String APP_HOST = "http://app.ehsy.cn/v20151127/index.php";
    public static final DisplayImageOptions OPTIONS=new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
}

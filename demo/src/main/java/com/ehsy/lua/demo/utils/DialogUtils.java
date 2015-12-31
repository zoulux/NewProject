package com.ehsy.lua.demo.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.ehsy.lua.demo.R;

/**
 * Created by Lua on 2015/12/17 17:29.
 */
public class DialogUtils {

 private static    ProgressDialog dialog;
    public static void show(Context context){
        if (context!=null){
            if (dialog==null){
                dialog=new ProgressDialog(context);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("提示");
                dialog.setMessage("加载中...");
            }
            dialog.show();
        }

    }

    public static void hiden(){
        if (dialog!=null&&dialog.isShowing()){
            dialog.cancel();
            dialog=null;
        }
    }
}

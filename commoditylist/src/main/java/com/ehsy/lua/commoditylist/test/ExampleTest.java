package com.ehsy.lua.commoditylist.test;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.ehsy.lua.commoditylist.biz.UserBiz;
import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;

/**
 * Created by Lua on 2015/12/30 11:39.
 */
public class ExampleTest extends InstrumentationTestCase implements HttpListener {
    private static final String TAG = "ExampleTest";
    public void test() throws Exception {
        UserBiz userBiz=new UserBiz();
        userBiz.sendAuthCode("13918208340",this);

    }

    @Override
    public void success(HttpParameters parameters) {
        Log.d(TAG, "success >>>>>>");
    }

    @Override
    public void faild(HttpParameters parameters) {

        Log.d(TAG, "faild >>>>>>>>>>");
    }
}

package com.ehsy.lua.betterhttp.presenter;


import com.ehsy.lua.betterhttp.model.HttpParameters;
import com.ehsy.lua.betterhttp.utils.VolleyUtils;
import com.ehsy.lua.betterhttp.view.HttpListener;
import com.ehsy.lua.betterhttp.view.ILoginView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lua on 2015/12/22 14:36.
 */
public class LoginPresenter implements ILoginPresenter{
    private static final String TAG = "LoginPresenter";

    ILoginView mLoginView;
    HttpListener listener;

    public LoginPresenter(ILoginView view,HttpListener listener) {
        this.mLoginView=view;
        this.listener=listener;
    }


    @Override
    public void login(String phone, String pwd) {
        Map<String,String> map=new HashMap<>();
        map.put("module", "user/login");
        map.put("mobile", phone);
        map.put("password", pwd);

        HttpParameters parameters = new HttpParameters();
        parameters.params=map;
        VolleyUtils.request(parameters, listener);
    }

    @Override
    public void register() {
        mLoginView.register();
    }


    @Override
    public void forgotPwd() {
        mLoginView.forgotPwd();
    }
}

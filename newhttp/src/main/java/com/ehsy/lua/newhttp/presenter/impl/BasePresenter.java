package com.ehsy.lua.newhttp.presenter.impl;

import com.ehsy.lua.newhttp.model.HttpParameters;
import com.ehsy.lua.newhttp.presenter.IBasePresenter;
import com.ehsy.lua.newhttp.utils.HttpListener;
import com.ehsy.lua.newhttp.utils.VolleyUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lua on 2015/12/24 10:00.
 */
public class BasePresenter implements IBasePresenter {
    private HttpListener listener;

    public void setListener(HttpListener listener) {
        this.listener = listener;
    }

    @Override
    public void sendAuthCode(String phone) {
        Map<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        params.put("channel", "1");
        params.put("module", "user/sendsms");
        HttpParameters parameters = new HttpParameters();
        parameters.params = params;

        VolleyUtils.request(parameters, listener);

    }

    @Override
    public void register(String phone, String pwd, String authCode) {
        Map<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        params.put("password", pwd);
        params.put("auth_code", authCode);
        params.put("ref_uid", "1111");
        params.put("module", "user/registerphone");

        HttpParameters parameters = new HttpParameters();
        parameters.params = params;
        VolleyUtils.request(parameters, listener);
    }

    @Override
    public void login(String phone, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("module", "user/login");
        map.put("mobile", phone);
        map.put("password", pwd);

        HttpParameters parameters = new HttpParameters();
        parameters.params = map;
        VolleyUtils.request(parameters, listener);
    }

    @Override
    public void forgotPwd(String phone, String pwd, String authCode) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("password", pwd);
        map.put("auth_code", authCode);
        map.put("module", "user/forgotpwd");

        HttpParameters parameters = new HttpParameters();
        parameters.params = map;
        VolleyUtils.request(parameters, listener);
    }


}

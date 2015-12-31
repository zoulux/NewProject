package com.ehsy.lua.commoditylist.biz;

import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;
import com.ehsy.lua.commoditylist.model.User;
import com.ehsy.lua.commoditylist.utils.VolleyUtils;

/**
 * Created by Lua on 2015/12/30 9:05.
 */
public class UserBiz {

    public void register(User user, String authCode,HttpListener listener) {
        HttpParameters parameters = new HttpParameters();
        parameters.addParameter("mobile", user.getPhone());
        parameters.addParameter("password", user.getPwd());
        parameters.addParameter("auth_code", authCode);
        parameters.addParameter("ref_uid", "1111");
        parameters.addParameter("module", "user/registerphone");
        VolleyUtils.request(parameters, listener);
    }

    public  void sendAuthCode(String phone,HttpListener listener){

        HttpParameters parameters = new HttpParameters();
        parameters.addParameter("mobile", phone);
        parameters.addParameter("channel", "1");
        parameters.addParameter("module", "user/sendsms");
        VolleyUtils.request(parameters, listener);
    }

    public void forgot(User user, String authCode,HttpListener listener) {
        HttpParameters parameters = new HttpParameters();
        parameters.addParameter("mobile", user.getPhone());
        parameters.addParameter("password", user.getPwd());
        parameters.addParameter("auth_code", authCode);
        parameters.addParameter("module", "user/forgotpwd");


        VolleyUtils.request(parameters, listener);
    }

    public void login(User user,HttpListener listener) {
        HttpParameters parameters = new HttpParameters();
        parameters.addParameter("module", "user/login");
        parameters.addParameter("mobile", user.getPhone());
        parameters.addParameter("password", user.getPwd());

        VolleyUtils.request(parameters, listener);

    }


}

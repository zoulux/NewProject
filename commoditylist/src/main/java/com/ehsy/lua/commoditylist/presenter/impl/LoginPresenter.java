package com.ehsy.lua.commoditylist.presenter.impl;

import android.text.TextUtils;
import android.util.Log;

import com.ehsy.lua.commoditylist.biz.UserBiz;
import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;
import com.ehsy.lua.commoditylist.model.User;
import com.ehsy.lua.commoditylist.presenter.ILoginPresenter;
import com.ehsy.lua.commoditylist.utils.CommonUtils;
import com.ehsy.lua.commoditylist.view.ILoginView;

/**
 * Created by Lua on 2015/12/24 15:54.
 */
public class LoginPresenter implements ILoginPresenter, HttpListener {
    private static final String TAG = "LoginPresenter";
    private ILoginView loginView;
    private User user;
    private UserBiz userBiz;

    public  LoginPresenter(ILoginView loginView){
        this.loginView=loginView;
        user=new User();
        userBiz=new UserBiz();
    }

    @Override
    public void login(String phone, String pwd) {

        user.setPhone(phone);
        user.setPwd(pwd);
        userBiz.login(user,this);

//
//        Map<String, String> map = new HashMap<>();
//        map.put("module", "user/login");
//        map.put("mobile", phone);
//        map.put("password", pwd);
//
//        HttpParameters parameters = new HttpParameters(map);
//        VolleyUtils.request(parameters, this);

    }

    @Override
    public void success(HttpParameters parameters) {

        Log.d(TAG, "success :" + parameters.result);

        if (! TextUtils.isEmpty(CommonUtils.parameterGetResult(parameters, "info"))){
            loginView.onFaild(CommonUtils.parameterGetResult(parameters, "info"));
        }else{
            loginView.onSuccess("用户名："+CommonUtils.parameterGetResult(parameters, "username"));
        }


    }

    @Override
    public void faild(HttpParameters parameters) {
        loginView.onFaild(parameters.result);
    }
}

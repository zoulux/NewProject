package com.ehsy.lua.commoditylist.presenter.impl;

import com.ehsy.lua.commoditylist.biz.UserBiz;
import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;
import com.ehsy.lua.commoditylist.model.User;
import com.ehsy.lua.commoditylist.presenter.IForgotPwdPresenter;
import com.ehsy.lua.commoditylist.utils.CommonUtils;
import com.ehsy.lua.commoditylist.view.IForgotPwdView;

/**
 * Created by Lua on 2015/12/24 17:08.
 */
public class ForgotPwdPresenter implements IForgotPwdPresenter, HttpListener {
    private IForgotPwdView forgotPwdView;
    private User user;
    private UserBiz userBiz;

    public ForgotPwdPresenter(IForgotPwdView forgotPwdView) {
        this.forgotPwdView = forgotPwdView;
        user=new User();
        userBiz=new UserBiz();
    }

    @Override
    public void forgot(String phone, String pwd, String authCode) {
//        Map<String, String> map = new HashMap<>();
//        map.put("mobile", phone);
//        map.put("password", pwd);
//        map.put("auth_code", authCode);
//        map.put("module", "user/forgotpwd");
//
//        HttpParameters parameters = new HttpParameters(map);
//        VolleyUtils.request(parameters, this);

        user.setPhone(phone);
        user.setPwd(pwd);
        userBiz.forgot(user,authCode,this);

    }

    @Override
    public void sendAuthCode(String phone) {

        userBiz.sendAuthCode(phone,this);

    //    CommonUtils.sendAuthCode(phone, this);
    }

    @Override
    public void success(HttpParameters parameters) {

        forgotPwdView.onSuccess(CommonUtils.parameterGetResult(parameters,"info"));

    }

    @Override
    public void faild(HttpParameters parameters) {

        forgotPwdView.onFaild(CommonUtils.parameterGetResult(parameters,"info"));
    }
}

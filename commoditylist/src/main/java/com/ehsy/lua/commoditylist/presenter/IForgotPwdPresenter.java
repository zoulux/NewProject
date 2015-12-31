package com.ehsy.lua.commoditylist.presenter;

/**
 * Created by Lua on 2015/12/24 17:07.
 */
public interface IForgotPwdPresenter {
    void forgot(String phone,String pwd,String authCode);
    void sendAuthCode(String phone);
}

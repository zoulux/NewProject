package com.ehsy.lua.newhttp.presenter;

/**
 * Created by Lua on 2015/12/23 9:10.
 */
public interface IForgotPwdPresenter {
    void sendAuthCode(String phone);
    void submit(String phone,String pwd,String authCode);
}

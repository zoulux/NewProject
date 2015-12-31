package com.ehsy.lua.newhttp.presenter;

/**
 * Created by Lua on 2015/12/24 9:59.
 */
public interface IBasePresenter {
    void sendAuthCode(String phone);
    void register(String phone,String pwd,String authCode);
    void login(String phone, String pwd);
    void forgotPwd(String phone,String pwd,String authCode);
}

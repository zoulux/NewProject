package com.ehsy.lua.betterhttp.presenter;

/**
 * Created by Lua on 2015/12/22 14:36.
 */
public interface ILoginPresenter {
    void login(String phone,String pwd);
    void register();
    void forgotPwd();
}

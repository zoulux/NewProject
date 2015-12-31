package com.ehsy.lua.newhttp.view;

/**
 * Created by Lua on 2015/12/22 17:17.
 */
public interface IForgotPwdView {
    void success(String successRes);
    void faild(String faildRes);
    String getPhone();
    String getPwd();
    String getAuthCode();

}

package com.ehsy.lua.newhttp.view;

/**
 * Created by Lua on 2015/12/22 14:35.
 */
public interface ILoginView extends IBaseView {
    void moveToRegisterView();
    void moveToForgotPwdView();
    void success(String successResult);
    void faild(String errorResult);
    String getPhone();
    String getPwd();
}

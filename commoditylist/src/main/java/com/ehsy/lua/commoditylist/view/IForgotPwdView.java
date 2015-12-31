package com.ehsy.lua.commoditylist.view;

/**
 * Created by Lua on 2015/12/24 17:11.
 */
public interface IForgotPwdView {
    void onSuccess(String result);
    void onFaild(String error);
    String getPhone();
    String getPwd();
    String getAuthCode();
}

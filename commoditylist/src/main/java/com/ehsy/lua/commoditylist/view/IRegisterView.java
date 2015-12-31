package com.ehsy.lua.commoditylist.view;

/**
 * Created by Lua on 2015/12/24 16:29.
 */
public interface IRegisterView {
    void onSuccess(String result);
    void onFaild(String error);
    String getPhone();
    String getPwd();
    String getAuthCode();
}

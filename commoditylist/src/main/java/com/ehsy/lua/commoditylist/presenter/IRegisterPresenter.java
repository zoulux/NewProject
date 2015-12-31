package com.ehsy.lua.commoditylist.presenter;

/**
 * Created by Lua on 2015/12/24 16:12.
 */
public interface IRegisterPresenter {
    void register(String phone,String pwd,String authCode);
    void sendAuthCode(String phone);
}

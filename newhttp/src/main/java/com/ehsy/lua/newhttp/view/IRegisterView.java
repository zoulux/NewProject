package com.ehsy.lua.newhttp.view;

/**
 * Created by Lua on 2015/12/22 17:04.
 */
public interface IRegisterView extends IBaseView{

    void success(String successResult);
    void faild(String errorResult);
    String getPhone();
    String getPwd();
    String getAuthCode();

}

package com.ehsy.lua.commoditylist.view;

/**
 * Created by Lua on 2015/12/24 16:00.
 */
public interface ILoginView {
    void onSuccess(String userName);

    void onFaild(String err);

    String getPhone();
    String getPwd();
}

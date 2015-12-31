package com.ehsy.lua.newhttp.model;

import com.ehsy.lua.newhttp.utils.HttpListener;

/**
 * Created by Lua on 2015/12/23 10:38.
 */
public class UserModel implements IUser {
    private String phone;
    private String pwd;

    private HttpListener listener;

    public UserModel(String phone, String pwd) {
        this.phone = phone;
        this.pwd = pwd;
    }

    public UserModel() {
    }

    public void setListener(HttpListener listener) {
        this.listener = listener;
    }



    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getPwd() {
        return pwd;
    }

    @Override
    public void setPhone(String phone) {
        this.phone=phone;
    }

    @Override
    public void setPwd(String pwd) {
        this.pwd=pwd;
    }

}

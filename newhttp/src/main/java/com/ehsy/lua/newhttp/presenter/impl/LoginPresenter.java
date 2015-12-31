package com.ehsy.lua.newhttp.presenter.impl;


import com.ehsy.lua.newhttp.model.HttpParameters;
import com.ehsy.lua.newhttp.model.UserModel;
import com.ehsy.lua.newhttp.presenter.ILoginPresenter;
import com.ehsy.lua.newhttp.utils.HttpListener;
import com.ehsy.lua.newhttp.view.ILoginView;

/**
 * Created by Lua on 2015/12/22 14:36.
 */
public class LoginPresenter extends BasePresenter implements ILoginPresenter, HttpListener {
    private static final String TAG = "LoginPresenter";
    private ILoginView loginView;
    private UserModel user;


    public LoginPresenter(ILoginView view) {
        super.setListener(this);
        this.loginView = view;
        user = new UserModel();
    }


    @Override
    public void moveToRegisterView() {
        loginView.moveToRegisterView();
    }

    @Override
    public void moveToForgotPwdView() {
        loginView.moveToForgotPwdView();
    }


    @Override
    public void success(HttpParameters successResult) {
        loginView.success(successResult.result);
    }

    @Override
    public void faild(HttpParameters errorResult) {
        loginView.faild(errorResult.result);
    }
}

package com.ehsy.lua.newhttp.presenter.impl;

import com.ehsy.lua.newhttp.model.HttpParameters;
import com.ehsy.lua.newhttp.model.UserModel;
import com.ehsy.lua.newhttp.utils.HttpListener;
import com.ehsy.lua.newhttp.view.IRegisterView;

/**
 * Created by Lua on 2015/12/22 17:23.
 */
public class RegisterPresenter extends BasePresenter implements HttpListener {
    private int channel = 1;
    private IRegisterView registerView;
    private UserModel user;

    public RegisterPresenter(IRegisterView view) {
        this.registerView = view;
        this.user = new UserModel();
        super.setListener(this);
    }

    
    @Override
    public void success(HttpParameters successResult) {
        registerView.success(successResult.result);
    }

    @Override
    public void faild(HttpParameters errorResult) {
        registerView.faild(errorResult.result);
    }
}
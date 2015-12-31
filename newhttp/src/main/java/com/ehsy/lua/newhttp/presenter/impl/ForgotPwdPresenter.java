package com.ehsy.lua.newhttp.presenter.impl;

import com.ehsy.lua.newhttp.model.HttpParameters;
import com.ehsy.lua.newhttp.model.UserModel;
import com.ehsy.lua.newhttp.utils.HttpListener;
import com.ehsy.lua.newhttp.view.IForgotPwdView;

/**
 * Created by Lua on 2015/12/23 9:11.
 */
public class ForgotPwdPresenter extends BasePresenter implements  HttpListener {
    private int channel=1;
    private IForgotPwdView forgotPwdView;
    private UserModel user;


    public ForgotPwdPresenter(IForgotPwdView view) {
       this.forgotPwdView=view;
        this.user=new UserModel();
      super.setListener(this);
    }


    @Override
    public void success(HttpParameters successResult) {
        forgotPwdView.success(successResult.result);
    }

    @Override
    public void faild(HttpParameters errorResult) {
        forgotPwdView.faild(errorResult.result);
    }
}

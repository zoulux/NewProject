package com.ehsy.lua.commoditylist.presenter.impl;

import com.ehsy.lua.commoditylist.biz.UserBiz;
import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;
import com.ehsy.lua.commoditylist.model.User;
import com.ehsy.lua.commoditylist.presenter.IRegisterPresenter;
import com.ehsy.lua.commoditylist.utils.CommonUtils;
import com.ehsy.lua.commoditylist.view.IRegisterView;

/**
 * Created by Lua on 2015/12/24 16:27.
 */
public class RegisterPresenter implements IRegisterPresenter, HttpListener {
    private IRegisterView registerView;
    private User user;
    private UserBiz userBiz;

    public  RegisterPresenter(IRegisterView registerView){
            this.registerView=registerView;
        user=new User();
        userBiz=new UserBiz();
    }
    @Override
    public void register(String phone, String pwd, String authCode) {
//        Map<String, String> params = new HashMap<>();
//        params.put("mobile", phone);
//        params.put("password", pwd);
//        params.put("auth_code", authCode);
//        params.put("ref_uid", "1111");
//        params.put("module", "user/registerphone");
//
//        HttpParameters parameters = new HttpParameters();
//        parameters.params = params;
//        VolleyUtils.request(parameters, this);

        user.setPhone(phone);
        user.setPwd(pwd);
        userBiz.register(user,authCode,this);
    }

    @Override
    public void sendAuthCode(String phone) {
//        CommonUtils.sendAuthCode(phone,this);

        userBiz.sendAuthCode(phone,this);
    }

    @Override
    public void success(HttpParameters parameters) {
        registerView.onSuccess(CommonUtils.parameterGetResult(parameters,"info"));

    }

    @Override
    public void faild(HttpParameters parameters) {
        registerView.onFaild(CommonUtils.parameterGetResult(parameters,"info"));
    }
}

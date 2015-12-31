package com.ehsy.lua.newhttp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ehsy.lua.newhttp.R;
import com.ehsy.lua.newhttp.presenter.impl.LoginPresenter;
import com.ehsy.lua.newhttp.view.ILoginView;


/**
 * Created by Lua on 2015/12/22 14:34.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private static final String TAG = "LoginActivity";

 //   private ILoginPresenter loginPresenter;
    private LoginPresenter presenter;

    private EditText etPhone,etPwd;
    private Button btLogin, btRegister,btForgotPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  loginPresenter = new LoginPresenter(this);
        presenter=new LoginPresenter(this);

        initViews();
    }


    private void initViews() {
        etPhone= (EditText) findViewById(R.id.et_user_phone);
        etPwd= (EditText) findViewById(R.id.et_user_pwd);
        btLogin= (Button) findViewById(R.id.bt_login);
        btRegister = (Button) findViewById(R.id.bt_jump_register);
        btForgotPwd= (Button) findViewById(R.id.bt_jump_forgotpwd);

        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
        btForgotPwd.setOnClickListener(this);
    }


    @Override
    public void success(String successResult) {

        Log.d(TAG, "success :"+successResult);
    }

    @Override
    public void faild(String errResult) {

        Log.d(TAG, "faild :"+errResult);
    }

    @Override
    public String getPhone() {
        return etPhone.getText().toString();
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString();
    }

    @Override
    public void moveToRegisterView() {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void moveToForgotPwdView() {
        Intent intent=new Intent(this,ForgotPwdActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick ");
        switch (v.getId()){
            case R.id.bt_login:
                presenter.login(getPhone(), getPwd());
                break;
            case R.id.bt_jump_register:
                presenter.moveToRegisterView();
                break;
            case R.id.bt_jump_forgotpwd:
                presenter.moveToForgotPwdView();
                break;

        }
    }
}

package com.ehsy.lua.betterhttp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ehsy.lua.betterhttp.R;
import com.ehsy.lua.betterhttp.model.HttpParameters;
import com.ehsy.lua.betterhttp.presenter.ILoginPresenter;
import com.ehsy.lua.betterhttp.presenter.LoginPresenter;


/**
 * Created by Lua on 2015/12/22 14:34.
 */
public class LoginActivity extends AppCompatActivity implements HttpListener, ILoginView, View.OnClickListener {
    private static final String TAG = "LoginActivity";

    private ILoginPresenter loginPresenter;

    private EditText etPhone,etPwd;
    private Button btLogin, btRegister,btForgotPwd;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(TAG, "onCreate ");
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter(this, this);

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
    public void success(HttpParameters successReult) {

        Log.d(TAG, "success :"+successReult.result);
    }

    @Override
    public void faild(HttpParameters errResult) {

        Log.d(TAG, "faild :"+errResult.result);
    }

    @Override
    public void register() {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);

    }

    @Override
    public void forgotPwd() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                loginPresenter.login(etPhone.getText().toString(), etPwd.getText().toString());
                break;
            case R.id.bt_jump_register:
                loginPresenter.register();
                break;


        }


    }
}

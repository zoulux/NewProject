package com.ehsy.lua.commoditylist.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ehsy.lua.commoditylist.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btRegister;
    private Button btLogin;
    private Button btForgotPwd;
    private Button btFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        btRegister = (Button) findViewById(R.id.bt_register);
        btLogin = (Button) findViewById(R.id.bt_login);
        btForgotPwd = (Button) findViewById(R.id.bt_forgot_pwd);
        btFind = (Button) findViewById(R.id.bt_find);

        btRegister.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        btForgotPwd.setOnClickListener(this);
        btFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_register:
                register();
                break;
            case R.id.bt_login:
                login();
                break;
            case R.id.bt_forgot_pwd:
                forgotPwd();
                break;
            case R.id.bt_find:
                find();
                break;
        }

    }

    private void forgotPwd() {
        Intent intent=new Intent(this,ForgotPwdActivity.class);
        startActivity(intent);
    }

    private void register() {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void find() {
        Intent intent=new Intent(this,FindActivity.class);
        startActivity(intent);
    }

    private void login() {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}

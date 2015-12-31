package com.ehsy.lua.commoditylist.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ehsy.lua.commoditylist.R;
import com.ehsy.lua.commoditylist.presenter.IForgotPwdPresenter;
import com.ehsy.lua.commoditylist.presenter.impl.ForgotPwdPresenter;
import com.ehsy.lua.commoditylist.view.IForgotPwdView;

public class ForgotPwdActivity extends AppCompatActivity implements IForgotPwdView, View.OnClickListener {

    private IForgotPwdPresenter forgotPwdPresenter;
    private EditText etPhone, etPwd, etAuthCode;
    private Button btGetAuthCode, btForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);
        forgotPwdPresenter = new ForgotPwdPresenter(this);
        initViews();
    }

    private void initViews() {
        etPhone = (EditText) findViewById(R.id.et_phone);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        etAuthCode = (EditText) findViewById(R.id.et_auth_code);
        btGetAuthCode = (Button) findViewById(R.id.bt_get_auth_code);
        btForgot = (Button) findViewById(R.id.bt_forgot_pwd);

        btForgot.setOnClickListener(this);
        btGetAuthCode.setOnClickListener(this);
    }

    @Override
    public void onSuccess(String result) {
        Toast.makeText(ForgotPwdActivity.this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFaild(String error) {
        Toast.makeText(ForgotPwdActivity.this, error, Toast.LENGTH_SHORT).show();
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
    public String getAuthCode() {
        return etAuthCode.getText().toString();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_get_auth_code:
                sendAuthCode();
                break;
            case R.id.bt_forgot_pwd:
                forgotPwd();
                break;
        }

    }

    private void forgotPwd() {
        forgotPwdPresenter.forgot(getPhone(), getPwd(), getAuthCode());
    }

    private void sendAuthCode() {
        forgotPwdPresenter.sendAuthCode(getPhone());
    }
}

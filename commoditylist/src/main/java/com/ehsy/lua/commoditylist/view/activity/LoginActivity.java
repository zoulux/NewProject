package com.ehsy.lua.commoditylist.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ehsy.lua.commoditylist.R;
import com.ehsy.lua.commoditylist.presenter.ILoginPresenter;
import com.ehsy.lua.commoditylist.presenter.impl.LoginPresenter;
import com.ehsy.lua.commoditylist.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private ILoginPresenter loginPresenter;

    private EditText etPhone,etPwd;
    private Button btLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter=new LoginPresenter(this);
        initViews();
    }

    private void initViews() {
        etPhone= (EditText) findViewById(R.id.et_phone);
        etPwd= (EditText) findViewById(R.id.et_pwd);
        btLogin= (Button) findViewById(R.id.bt_login);

        btLogin.setOnClickListener(this);
    }

    @Override
    public void onSuccess(String res) {
        Toast.makeText(LoginActivity.this, res, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFaild(String err) {
        Toast.makeText(LoginActivity.this, err, Toast.LENGTH_SHORT).show();

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
    public void onClick(View v) {
        loginPresenter.login(getPhone(),getPwd());
    }
}

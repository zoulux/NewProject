package com.ehsy.lua.commoditylist.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ehsy.lua.commoditylist.R;
import com.ehsy.lua.commoditylist.presenter.IRegisterPresenter;
import com.ehsy.lua.commoditylist.presenter.impl.RegisterPresenter;
import com.ehsy.lua.commoditylist.view.IRegisterView;

public class RegisterActivity extends AppCompatActivity implements IRegisterView, View.OnClickListener {
    private static final String TAG = "RegisterActivity";
    private EditText etPhone,etPwd,etAuthCode;
    private Button btGetAuthCode,btRegister;


    private IRegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter=new RegisterPresenter(this);
        initViews();
    }

    private void initViews() {
        etPhone= (EditText) findViewById(R.id.et_phone);
        etPwd= (EditText) findViewById(R.id.et_pwd);
        etAuthCode= (EditText) findViewById(R.id.et_auth_code);
        btGetAuthCode= (Button) findViewById(R.id.bt_get_auth_code);
        btRegister= (Button) findViewById(R.id.bt_register);

        btGetAuthCode.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }

    @Override
    public void onSuccess(String result) {
        Toast.makeText(RegisterActivity.this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFaild(String error) {

        Toast.makeText(RegisterActivity.this, error, Toast.LENGTH_SHORT).show();
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
        Log.d(TAG, "getAuthCode :"+etAuthCode.getText().toString());
        return etAuthCode.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_get_auth_code:
                sendAuthCode();
                break;
            case R.id.bt_register:
                register();
                break;
        }

    }

    private void register() {
        registerPresenter.register(getPhone(),getPwd(),getAuthCode());
    }

    private void sendAuthCode() {
        registerPresenter.sendAuthCode(getPhone());
    }
}

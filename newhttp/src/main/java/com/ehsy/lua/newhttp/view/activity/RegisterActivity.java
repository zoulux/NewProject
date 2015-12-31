package com.ehsy.lua.newhttp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ehsy.lua.newhttp.R;
import com.ehsy.lua.newhttp.presenter.impl.RegisterPresenter;
import com.ehsy.lua.newhttp.view.IRegisterView;

/**
 * Created by Lua on 2015/12/22 17:04.
 */
public class RegisterActivity extends AppCompatActivity implements IRegisterView, View.OnClickListener {
    private static final String TAG = "RegisterActivity";

    private EditText etPhone, etPwd, etAuthCode;
    private Button btGetAuthCode, btSumbit;

    private RegisterPresenter registerPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter = new RegisterPresenter(this);

        initViews();
    }

    private void initViews() {
        etPhone = (EditText) findViewById(R.id.et_user_phone);
        etPwd = (EditText) findViewById(R.id.et_user_pwd);
        etAuthCode = (EditText) findViewById(R.id.et_aut_code);
        btGetAuthCode = (Button) findViewById(R.id.bt_get_aut_code);
        btSumbit = (Button) findViewById(R.id.bt_registerphone);

        btGetAuthCode.setOnClickListener(this);
        btSumbit.setOnClickListener(this);
    }

    @Override
    public void success(String successResult) {
        Log.d(TAG, "success :" + successResult);

    }

    @Override
    public void faild(String errorResult) {

        Log.d(TAG, "faild :" + errorResult);
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
            case R.id.bt_get_aut_code:
                registerPresenter.sendAuthCode(getPhone());
                break;
            case R.id.bt_registerphone:
                registerPresenter.register(getPhone(), getPwd(), getAuthCode());
                break;
        }

    }
}

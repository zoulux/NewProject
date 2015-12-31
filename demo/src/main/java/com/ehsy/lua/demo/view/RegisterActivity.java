package com.ehsy.lua.demo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ehsy.lua.demo.common.HttpListener;
import com.ehsy.lua.demo.model.HttpParameters;
import com.ehsy.lua.demo.common.MyHandler;
import com.ehsy.lua.demo.common.MyTask;
import com.ehsy.lua.demo.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, HttpListener {
    private static final String TAG = "RegisterActivity";

    private EditText etUserPhone;
    private EditText etUserPwd;
    private EditText etAuthCode;
    private Button btGetAutCode;
    private Button btRegister;

    private int channel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();


    }

    private void initViews() {
        etUserPhone = (EditText) findViewById(R.id.id_et_user_phone);
        etUserPwd = (EditText) findViewById(R.id.id_et_user_pwd);
        etAuthCode = (EditText) findViewById(R.id.id_et_aut_code);
        btGetAutCode = (Button) findViewById(R.id.id_bt_get_aut_code);
        btRegister = (Button) findViewById(R.id.id_bt_registerphone);
        etUserPwd= (EditText) findViewById(R.id.id_et_user_pwd);

        btGetAutCode.setOnClickListener(this);
        btRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_bt_get_aut_code:
                getAutCode();
                break;
            case R.id.id_bt_registerphone:
                register();
                break;
        }

    }

    private void register() {
        Map<String, String> params = new HashMap<>();
        params.put("mobile", etUserPhone.getText().toString());
        params.put("password", etUserPwd.getText().toString());
        params.put("auth_code", etAuthCode.getText().toString());
        params.put("ref_uid", "1111");
        params.put("module", "user/registerphone");


        HttpParameters parameters = new HttpParameters();
        parameters.context = this;
        parameters.params = params;

        MyTask task = new MyTask(parameters, new MyHandler(this));
        task.go();
    }

    private void getAutCode() {
        Map<String, String> params = new HashMap<>();
        params.put("mobile", etUserPhone.getText().toString());
        params.put("channel", String.valueOf(channel++));
        params.put("module", "user/sendsms");

        HttpParameters parameters = new HttpParameters();
        parameters.context = this;
        parameters.params = params;

        MyTask task = new MyTask(parameters, new MyHandler(this));
        task.go();
    }


    @Override
    public void success(HttpParameters successResult) {
        Log.d(TAG, "success " + successResult.result);
    }

    @Override
    public void faild(HttpParameters err) {
        Log.d(TAG, "faild " + err.result);
    }
}

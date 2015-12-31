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

public class ForgotPwdActivity extends AppCompatActivity implements View.OnClickListener, HttpListener {
    private static final String TAG = "ForgotPwdActivity";
    private EditText etUserPhone;
    private EditText etUserPwd;
    private EditText etAuthCode;
    private Button btGetAuthCode;
    private Button btSubmit;


    private int channel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);
        initViews();
    }

    private void initViews() {
        etUserPhone = (EditText) findViewById(R.id.id_et_user_phone);
        etAuthCode = (EditText) findViewById(R.id.id_et_aut_code);
        btGetAuthCode = (Button) findViewById(R.id.id_bt_get_aut_code);
        btSubmit = (Button) findViewById(R.id.id_bt_submit);
        etUserPwd= (EditText) findViewById(R.id.id_et_user_pwd);

        btGetAuthCode.setOnClickListener(this);
        btSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_bt_get_aut_code:
                getAuthCode();
                break;
            case R.id.id_bt_submit:
                submit();
                break;
        }

    }

    private void submit() {

        Map<String, String> map = new HashMap<>();
        map.put("mobile", etUserPhone.getText().toString());
        map.put("password", etUserPwd.getText().toString());
        map.put("auth_code", etAuthCode.getText().toString());
        map.put("module", "user/forgotpwd");

        HttpParameters parameters = new HttpParameters();
        parameters.params = map;
        parameters.context = this;

        MyTask task = new MyTask(parameters, new MyHandler(this));
        task.go();
    }

    private void getAuthCode() {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", etUserPhone.getText().toString());
        map.put("channel", String.valueOf(channel++));
        map.put("module", "user/sendsms");

        HttpParameters parameters = new HttpParameters();
        parameters.params = map;
        parameters.context = this;

        MyTask task = new MyTask(parameters, new MyHandler(this));
        task.go();

    }

    @Override
    public void success(HttpParameters successResult) {
        Log.d(TAG, "success :" + successResult.result);
    }

    @Override
    public void faild(HttpParameters err) {
        Log.d(TAG, "faild " + err.result);
    }
}

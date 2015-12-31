package com.ehsy.lua.demo.view;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HttpListener {
    private static final String TAG = "MainActivity";

    private Button btLogin;
    private Button btRegister;
    private Button btforgotpwd;
    private EditText etUserPhone;
    private EditText etUserPwd;


    public static String host = "http://app.ehsy.cn/v20151127/index.php";

    private HttpParameters params;
    private MyTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


    }

    private void initViews() {
        etUserPhone = (EditText) findViewById(R.id.id_et_user_phone);
        etUserPwd = (EditText) findViewById(R.id.id_et_user_pwd);
        btLogin = (Button) findViewById(R.id.id_bt_login);
        btRegister = (Button) findViewById(R.id.id_bt_jump_register);
        btforgotpwd = (Button) findViewById(R.id.id_bt_jump_forgotpwd);


        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
        btforgotpwd.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.id_bt_login:
                login();
                break;
            case R.id.id_bt_jump_register:
                register();
                break;
            case R.id.id_bt_jump_forgotpwd:
                forgotpwd();
                break;


        }


    }


    private void forgotpwd() {
        Intent intent = new Intent(this, ForgotPwdActivity.class);
        startActivity(intent);
    }

    private void register() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void login() {
        Map<String, String> map = new HashMap<>();
        map.put("module", "user/login");
        map.put("mobile", etUserPhone.getText().toString());
        map.put("password", etUserPwd.getText().toString());

        HttpParameters parameters = new HttpParameters();
        parameters.context = this;
        parameters.params = map;

        MyTask task = new MyTask(parameters, new MyHandler(this));
        task.go();
    }


    @Override
    public void success(HttpParameters successResult) {
   //     Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "success :" + successResult.result);
    }

    @Override
    public void faild(HttpParameters err) {
      //  Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "faild :" + err.result);
    }


    public void test(View v){
        Map<String, String> map = new HashMap<>();
        map.put("module", "user/login");
        map.put("mobile", etUserPhone.getText().toString());
        map.put("password", etUserPwd.getText().toString());

        HttpParameters parameters = new HttpParameters();
        parameters.context = this;
        parameters.params = map;
        MyTask task1=new MyTask(parameters,new MyHandler(this));
        task1.go();
    }
}
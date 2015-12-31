package com.ehsy.lua.newhttp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ehsy.lua.newhttp.R;
import com.ehsy.lua.newhttp.presenter.impl.ForgotPwdPresenter;
import com.ehsy.lua.newhttp.view.IForgotPwdView;

/**
 * Created by Lua on 2015/12/22 17:17.
 */
public class ForgotPwdActivity extends AppCompatActivity implements IForgotPwdView, View.OnClickListener {
    private static final String TAG = "ForgotPwdActivity";

  private ForgotPwdPresenter forgotPwdPresenter;
    private EditText etPhone,etPwd,etAuthCode;
    private Button btAuthCode,btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);
        forgotPwdPresenter=new ForgotPwdPresenter(this);
        initviews();
    }

    private void initviews() {
        etPhone= (EditText) findViewById(R.id.et_user_phone);
        etPwd= (EditText) findViewById(R.id.et_user_pwd);
        etAuthCode= (EditText) findViewById(R.id.et_aut_code);
        btAuthCode= (Button) findViewById(R.id.bt_get_aut_code);
        btSubmit= (Button) findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(this);
        btAuthCode.setOnClickListener(this);

    }

    @Override
    public void success(String successRes) {
        Log.d(TAG, "success :"+successRes);

    }

    @Override
    public void faild(String faildRes) {

        Log.d(TAG, "faild :"+faildRes);
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

        switch (v.getId()){
            case R.id.bt_get_aut_code:
                forgotPwdPresenter.sendAuthCode(getPhone());
                break;
            case R.id.bt_submit:
                forgotPwdPresenter.forgotPwd(getPhone(), getPwd(), getAuthCode());
                break;
        }
    }
}

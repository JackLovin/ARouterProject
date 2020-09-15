package com.sunyard.mylibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;


import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.textfield.TextInputEditText;
import com.sunyard.commonmodule.base.IBaseActivity;
import com.sunyard.commonmodule.constants.Author;
import com.sunyard.commonmodule.constants.PathConstants;


/**
 * @package name：com.sunyard.mylibrary
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/9/14 5:09 PM
 */


@Route(path = PathConstants.LOGIN_PATH, extras = 1)
public class LoginActivity extends Activity {

    TextInputEditText textInputEditText;
    TextInputEditText etPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textInputEditText=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
    }
    public String getStringByUI(View view) {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString().trim();
        } else if (view instanceof TextView) {
            return ((TextView) view).getText().toString().trim();
        }
        return "";
    }

    public void getData(View view) {


        new LoginModel().getAccountData(getStringByUI(textInputEditText), getStringByUI(etPassword), new ILoginCallback() {
            @Override
            public void onSuccess(Boolean isLogin) {
                if (isLogin) {


                }
            }

            @Override
            public void onFailed(String msg) {

            }
        });

    }


}


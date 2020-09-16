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
import android.widget.Toast;

import androidx.annotation.Nullable;

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


@Route(path = PathConstants.LOGIN_PATH)
public class LoginActivity extends IBaseActivity {

    TextInputEditText textInputEditText;
    TextInputEditText etPassword;
    private static final String TAG = "LoginActivity";

    @Override
    public void initView() {
        textInputEditText=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }





}


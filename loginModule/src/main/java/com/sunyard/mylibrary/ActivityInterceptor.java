package com.sunyard.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sunyard.commonmodule.base.IBaseActivity;
import com.sunyard.commonmodule.constants.PathConstants;

@Route(path = PathConstants.COM_ACTIVITY_INTERCEPTOR)
public class ActivityInterceptor extends IBaseActivity {

    @Override
    public void initView() {

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_interceptor;
    }


}
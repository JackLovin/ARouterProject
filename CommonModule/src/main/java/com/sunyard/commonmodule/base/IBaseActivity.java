package com.sunyard.commonmodule.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.launcher.ARouter;

public abstract class IBaseActivity extends AppCompatActivity  {
    public abstract void initView();


    public abstract int getContentViewId();

    public IBaseActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ARouter.getInstance().inject(this);

        initView();
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        ARouter.getInstance().inject(this);
    }

}

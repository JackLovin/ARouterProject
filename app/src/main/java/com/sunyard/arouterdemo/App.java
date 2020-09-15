package com.sunyard.arouterdemo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.base.BaseApplication;

/**
 * @author xujun  on 2/7/2018.
 */
public class App extends BaseApplication {

    static App mApp;

    public static App getApp() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;

    }
}

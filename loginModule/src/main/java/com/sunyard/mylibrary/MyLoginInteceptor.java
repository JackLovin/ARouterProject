package com.sunyard.mylibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.constants.PathConstants;

import static com.sunyard.commonmodule.base.BaseApplication.getApp;

/**
 * 登录拦截器
 */
@Interceptor(priority = 100)
public class MyLoginInteceptor implements IInterceptor {
    private Context mContext;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        int extra = postcard.getExtra();
        Log.e(TAG, "process: "+postcard.getPath() );
        if(postcard.getPath().equals(PathConstants.COM_ACTIVITY_INTERCEPTOR) ){
            ARouter.getInstance().build(PathConstants.LOGIN_PATH).navigation();

        }else {
            callback.onContinue(postcard);
        }
    }

    private static final String TAG = "MyLoginInteceptor";
    @Override
    public void init(Context context) {
        this.mContext = context;
        Log.e(TAG, "init: " );
    }
}

package com.sunyard.commonmodule;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.constants.PathConstants;

/**
 * 登录拦截器
 */
@Interceptor(priority = 100)
public class MyLoginInteceptor implements IInterceptor {
    private Context mContext;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        int extra = postcard.getExtra();
        Log.e(TAG, "process: "+extra );
        if(extra == 0){
                ARouter.getInstance().build(PathConstants.MAIN_PATH).navigation();
                callback.onInterrupt(null);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContext,"请先登录",Toast.LENGTH_SHORT).show();
                    }
                });
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

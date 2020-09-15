package com.sunyard.mylibrary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.base.BaseActivity;
import com.sunyard.commonmodule.constants.Album;
import com.sunyard.commonmodule.constants.PathConstants;

/**
 * @package name：com.sunyard.mylibrary
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/9/14 5:09 PM
 */
@Route(path = PathConstants.LOGIN_PATH)
public class LoginAty extends BaseActivity {

    @Autowired
    String string;
    @Autowired
    int ints;
    @Autowired
    Bundle bundleValue;
    @Autowired
    Album album;

    private static final String TAG = "CSJ";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_about);

        Log.e(TAG, "string: "+ string);
        Log.e(TAG, "ints: "+ ints);
        Log.e(TAG, "bundleValue: "+ bundleValue.getString("1"));
       Log.e(TAG, "bundleValue: "+ bundleValue.getString("2"));
       Log.e(TAG, "bundleValue: "+ bundleValue.getString("3"));
//        Log.e(TAG, "bundleValue: "+ album.getmCount());
//        Log.e(TAG, "bundleValue: "+ album.getmId());
//        Log.e(TAG, "bundleValue: "+ album.getmDisplayName());

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}

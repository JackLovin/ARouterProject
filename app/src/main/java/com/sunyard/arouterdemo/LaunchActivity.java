package com.sunyard.arouterdemo;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.constants.PathConstants;


public class LaunchActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().build(PathConstants.LOGIN_PATH).navigation();
//        Bundle bundle = new Bundle();
//        // Album album = new Album("a", "b", "c", 1000L);
//        Author author=new Author();
//        author.setAge(18);
//        author.setName("csj");
//        author.setCounty("hangzhou");
//        bundle.putString("1", "one");
//        bundle.putString("2", "two");
//        bundle.putString("3", "three");
//        ARouter.getInstance().build(PathConstants.LOGIN_PATH).
//                withString("string", "我是字符串").
//                withInt("ints", 1)
//
//                .withBundle("bundleValue", bundle)
////                       .withParcelable("album", album)
//                .withObject("key4", author)
//                .navigation();
    }
}
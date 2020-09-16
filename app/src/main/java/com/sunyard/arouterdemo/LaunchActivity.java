package com.sunyard.arouterdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.ITravelService;
import com.sunyard.commonmodule.ImplTestBTravelService;
import com.sunyard.commonmodule.Person;
import com.sunyard.commonmodule.RouteServiceManager;
import com.sunyard.commonmodule.constants.Author;
import com.sunyard.commonmodule.constants.PathConstants;


public class LaunchActivity extends Activity {
    private static final String TAG = "LaunchActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


    public void intentAty(View view) {
        ARouter.getInstance().build(PathConstants.LOGIN_PATH).navigation();

    }

    public void withParcelable(View view) {
        Person person = new Person();
        person.age = 20;
        person.name = "xujun";
        person.sex = 1;
        person.weight = 60.5f;
        ARouter.getInstance().build(PathConstants.COM_INTENTDATA).
                withParcelable("person", person).navigation();

    }

    public void withObject(View view) {
        Author author = new Author();
        author.setName("陈胜杰");
        author.setAge(18);
        author.setCounty("hangzhoiu");
        ARouter.getInstance().build(PathConstants.COM_INTENTDATA).
                withObject("author", author).navigation();

    }

    public void intentInterceptor(View view) {
        ARouter.getInstance().build(PathConstants.COM_ACTIVITY_INTERCEPTOR).navigation();

    }

    public void intentData(View view) {
        ARouter.getInstance().build(PathConstants.COM_INTENTDATA).
                withString("name", "我是陈胜杰").
                withInt("age", 18).navigation();

    }
    public void intentService(View view) {
//        //执行旅游
//        ITravelService iTravelService = RouteServiceManager.provide(ImplTestBTravelService.class, PathConstants.SERVICE_TESTB_TRAVEL);
//        iTravelService.choiceCountry();
//        ITravelService iTravelService = (ITravelService) ARouter.getInstance().build(PathConstants.SERVICE_NEWS).navigation();
//        iTravelService.choiceCountry();
        ITravelService iTravelService1=new ImplTestBTravelService();
        iTravelService1.choiceCountry();
    }

    public void startAtyForResult(View view) {
        Postcard postcard = ARouter.getInstance().build(PathConstants.COM_ACTIVITY_RESULT);
        LogisticsCenter.completion(postcard);
        Class<?> destination = postcard.getDestination();
        Intent intent = new Intent(this, destination);
        startActivityForResult(intent, 123);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            Log.e(TAG, "onActivityResult: requestCode=" + requestCode
                    + " resultCode=" + resultCode + " data=" + data.getStringExtra("result"));

        }
    }
}
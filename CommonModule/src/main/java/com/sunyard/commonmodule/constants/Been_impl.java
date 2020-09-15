package com.sunyard.commonmodule.constants;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @package name：com.sunyard.commonmodule.constants
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/9/15 10:51 AM
 */
@Route(path = "/service/json")//这里必须这样写，ARouter在你传Object的时候会自己使用这个类，我们只管生成这个类
//因为实现了ARouter的SerializationService接口，我们自定义的对象即可不用写代码序列化而直接使用
public class Been_impl implements SerializationService {
    Gson mGson;
    private void check(){
        if (mGson==null) {
            mGson = new Gson();
        }
    }
    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        check();
        return mGson.fromJson(input, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        check();
        return mGson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        check();
        return mGson.fromJson(input, clazz);
    }

    @Override
    public void init(Context context) {
        check();
    }
}
package com.sunyard.commonmodule;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.constants.PathConstants;

/**
 * @package name：com.sunyard.commonmodule
 * @describe
 * @anthor jokerlover
 * @email:shengj.chen@sunyard.com
 * @time 2020/9/16 10:37 AM
 */
@Route(path = PathConstants.SERVICE_NEWS,name = "新闻")
public class ImplTestBTravelService implements ITravelService {

    @Override
    public void choiceCountry() {
        ARouter.getInstance().build(PathConstants.LOGIN_PATH).navigation();

        //Log.e("CCCCC", "choiceCountry: 陈陈陈 " );
    }


    @Override
    public void init(Context context) {

    }
}

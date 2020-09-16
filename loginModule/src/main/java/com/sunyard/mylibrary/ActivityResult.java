package com.sunyard.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sunyard.commonmodule.base.IBaseActivity;
import com.sunyard.commonmodule.constants.PathConstants;


@Route(path = PathConstants.COM_ACTIVITY_RESULT)
public class ActivityResult extends IBaseActivity {
    public static final String RESULT = "result";

    @Override
    public void initView() {

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_result;
    }


    public void returnBtn(View view) {
        Log.e("TAG", "onBackPressed: ");
        Intent data = new Intent();
        data.putExtra(RESULT, "陈胜杰");
        setResult(Activity.RESULT_OK, data);
        finish();

    }

}
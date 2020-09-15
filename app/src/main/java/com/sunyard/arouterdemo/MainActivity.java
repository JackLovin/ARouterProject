package com.sunyard.arouterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sunyard.commonmodule.base.BaseActivity;
import com.sunyard.commonmodule.constants.Album;
import com.sunyard.commonmodule.constants.PathConstants;

@Route(path = "Activity1")
public class MainActivity extends BaseActivity implements View.OnClickListener {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv:
                //ARouter.getInstance().build(PathConstants.LOGIN_PATH).navigation();
                Bundle bundle = new Bundle();
                Album album = new Album("a", "b", "c", 1000L);

                bundle.putString("1", "one");
                bundle.putString("2", "two");
                bundle.putString("3", "three");
                ARouter.getInstance().build(PathConstants.LOGIN_PATH).
                        withString("string", "我是字符串").
                        withInt("ints", 1)
                      .withBundle("bundleValue", bundle)
//                        .withParcelable("album", album)
                        .navigation();
                break;
        }
    }
}
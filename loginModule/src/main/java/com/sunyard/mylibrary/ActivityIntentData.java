package com.sunyard.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sunyard.commonmodule.Person;
import com.sunyard.commonmodule.base.IBaseActivity;
import com.sunyard.commonmodule.constants.Author;
import com.sunyard.commonmodule.constants.PathConstants;

import org.w3c.dom.Text;

@Route(path = PathConstants.COM_INTENTDATA)
public class ActivityIntentData extends IBaseActivity {

    @Autowired
    String name;
    @Autowired
    int age;
    TextView text;



    @Autowired()
    Person person;

    @Autowired()
    Author author;

    @Override
    public void initView() {
        text=findViewById(R.id.text);
        if (name != null) {
            text.setText(name+"    "+age);

        }else  if(person!=null){
            text.setText(person.toString());
        }else {
            text.setText(author.getName()+"--"+author.getAge()+"--"+author.getCounty());

        }


    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_intent_data;
    }

}
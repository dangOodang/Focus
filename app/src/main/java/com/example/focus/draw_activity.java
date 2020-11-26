package com.example.focus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class draw_activity extends AppCompatActivity {
    private static List<Person> mData;        //  数据值,  数据姓名


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  柱形图
        initSQLiteTwo();
        PColumn pColumn = new PColumn(mData);    //  将数据源传递给自定义柱形图类
    }

    private void initSQLiteTwo() {
        //初始化数据
        mData = new ArrayList<>();
        DBHelper.getlist(mData);
    }
}
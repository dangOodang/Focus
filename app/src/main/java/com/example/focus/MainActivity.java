package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextview;
    private Button mBtnTextView1;
    private Button mBtnEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        Bmob.initialize(this, "aee93d95922e83de7d799cd06ad844ad");
//        mBtnTextview = findViewById(R.id.btn_textview);
//        mBtnTextview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
//                startActivity(intent);
//            }
//        });
//        mBtnTextView1 = findViewById(R.id.btn_textview1);
//        mBtnTextView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ButtonActivity.class);
//                startActivity(intent);
//            }
//        });
        mBtnEdittext = findViewById(R.id.btn_edittext);//该按钮按完跳转到登录页面
        mBtnEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EdittextActivity.class);
                startActivity(intent);
            }
        });
    }
}
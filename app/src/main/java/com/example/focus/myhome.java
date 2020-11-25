package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class myhome extends AppCompatActivity {
    public static String text11,text111,name11;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhome);

        TextView textView1 = findViewById(R.id.up_name);
        textView1.setText(name11);

//        Intent intent = getIntent();
//        String message = intent.getStringExtra(setname.EXTRA_MESSAGE);
//        TextView textView = findViewById(R.id.up_name);
//        textView.setText(message);

        TextView mBtv1 = findViewById(R.id.tv_1);
        mBtv1.setOnClickListener(v -> {
            Intent intent1 =new Intent(myhome.this,setname.class);
            startActivity(intent1);
        });
        TextView mBtv2 = findViewById(R.id.tv_2);
        mBtv2.setOnClickListener(v -> {
            Intent intent12 =new Intent(myhome.this,updatepassword.class);
            startActivity(intent12);
        });
        TextView mBtv3 = findViewById(R.id.tv_3);
        mBtv3.setOnClickListener(v -> {
            Intent intent13 =new Intent(myhome.this,versionnumber.class);
            startActivity(intent13);
        });

        Button mBtnmain = findViewById(R.id.btn_login22);//该按钮按完跳转到登录页面
        mBtnmain.setOnClickListener(v -> {
            Intent intent14 = new Intent(myhome.this,MainActivity.class);
            startActivity(intent14);
        });
//        mBtout=findViewById(R.id.but_out);
//        mBtout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(myhome.this,versionnumber.class);
//                startActivity(intent);
//            }
//        });

    }
}

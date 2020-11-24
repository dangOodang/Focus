package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class myhome extends AppCompatActivity {
    private TextView mBtout;
    private TextView mBtv1,mBtv2,mBtv3,mBtv4;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhome);

//        Intent intent = getIntent();
//        String message = intent.getStringExtra(setname.EXTRA_MESSAGE);
//        TextView textView = findViewById(R.id.up_22);
//        textView.setText(message);

        mBtv1=findViewById(R.id.tv_1);
        mBtv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(myhome.this,setname.class);
                startActivity(intent);
            }
        });
        mBtv2=findViewById(R.id.tv_2);
        mBtv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(myhome.this,updatepassword.class);
                startActivity(intent);
            }
        });
        mBtv3=findViewById(R.id.tv_3);
        mBtv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(myhome.this,versionnumber.class);
                startActivity(intent);
            }
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

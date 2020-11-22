package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class set extends AppCompatActivity {
    private Button mBtnX;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;
    private TextView mTv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        mBtnX = findViewById(R.id.btn_1);
        mBtnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(set.this,myhome.class);
                startActivity(intent);
            }
        });
        mTv2 = findViewById(R.id.tv_2);
        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(set.this, setname.class);
                startActivity(intent);
            }
        });

        mTv3 = findViewById(R.id.tv_3);
        mTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(set.this, setpicture.class);
                startActivity(intent);
            }
        });

        mTv4 = findViewById(R.id.tv_4);
        mTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(set.this, updatepassword.class);
                startActivity(intent);
            }
        });

        mTv5 = findViewById(R.id.tv_5);
        mTv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(set.this, versionnumber.class);
                startActivity(intent);
            }
        });
    }
}
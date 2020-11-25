package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class setname extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.focus.MESSAGE";
    private Button mBtbbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setname);

        Button mBtnre = findViewById(R.id.bbbtn);
        mBtnre.setOnClickListener(v -> {
            Intent intent;
            intent = new Intent(setname.this, myhome.class);
            startActivity(intent);
        });

        mBtbbtn=findViewById(R.id.bbtn);
        mBtbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.et_1);
                new Thread(new SubThread_T1(editText.getText().toString())).start();//跳转到SubThread_TT子进程
//                Intent intent;
//                intent = new Intent(setname.this, myhome.class);
//                startActivity(intent);
            }
        });
    }



}
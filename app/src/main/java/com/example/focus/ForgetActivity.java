package com.example.focus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetActivity extends AppCompatActivity {
    private Button mBtnGET;
    private EditText email3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        mBtnGET = findViewById(R.id.btn_get);
        mBtnGET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email3=(EditText) findViewById(R.id.forget_1);
                new Thread(new SubThread_FF(email3.getText().toString())).start();//跳转到忘记密码SubThread_FF子进程
            }
        });
    }
}
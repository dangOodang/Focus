package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setpicture extends AppCompatActivity {
    private Button mBtnp;
    private Button mBtnpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpicture);
        mBtnpp = findViewById(R.id.bbbbtn);
        mBtnpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(setpicture.this, set.class);
                startActivity(intent);
            }
        });
        mBtnp = findViewById(R.id.btnp);
        mBtnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(setpicture.this, set.class);
                startActivity(intent);
            }
        });
    }
}
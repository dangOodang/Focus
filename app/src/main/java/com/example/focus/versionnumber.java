package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class versionnumber extends AppCompatActivity {
    private Button mBUtton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.versionnumber);

        mBUtton=findViewById(R.id.but_1);
        mBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(versionnumber.this,set.class);
                startActivity(intent);
            }
        });

    }
}
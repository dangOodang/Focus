package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class versionnumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.versionnumber);

        Button mBUtton = findViewById(R.id.but_1);
        mBUtton.setOnClickListener(v -> {
            Intent intent=new Intent(versionnumber.this,myhome.class);
            startActivity(intent);
        });

    }
}

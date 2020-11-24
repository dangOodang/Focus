package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class updatepassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatepassword);

        Button mBUtton = findViewById(R.id.button_back);
        mBUtton.setOnClickListener(v -> {
            Intent intent=new Intent(updatepassword.this,myhome.class);
            startActivity(intent);
        });
        Button mBUtton1 = findViewById(R.id.but_set);
        mBUtton1.setOnClickListener(v -> {
            Intent intent=new Intent(updatepassword.this,myhome.class);
            startActivity(intent);
        });
    }
}

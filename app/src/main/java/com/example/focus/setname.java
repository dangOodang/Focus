package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setname extends AppCompatActivity {
    private Button mBtnre;
    private Button mBtnsure ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setname);
        mBtnre = findViewById(R.id.bbbtn);
        mBtnre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(setname.this, set.class);
                startActivity(intent);
            }
        });
        mBtnsure = findViewById((R.id.bbtn));
        mBtnsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(setname.this, set.class);
                startActivity(intent);
            }
        });
    }
}
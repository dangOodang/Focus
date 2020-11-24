package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class setname extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.focus.MESSAGE";
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

    }

    public void sendMessage(View view){
        Intent intent = new Intent(setname.this,myhome.class);
        EditText editText = findViewById(R.id.et_1);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
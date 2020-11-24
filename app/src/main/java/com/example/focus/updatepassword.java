package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class updatepassword extends AppCompatActivity {
    private Button mBUtton;
    private Button mBUtton1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatepassword);

        mBUtton=findViewById(R.id.button_back);
        mBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(updatepassword.this,myhome.class);
                startActivity(intent);
            }
        });
        mBUtton=findViewById(R.id.but_set);
        mBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(updatepassword.this,myhome.class);
                startActivity(intent);
            }
        });
    }
}

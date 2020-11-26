package com.example.focus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class timeendActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeend);
        int  Timee=   getIntent().getIntExtra("time",0);
        String User = getIntent().getStringExtra("name") ;
        TextView lblTitle=(TextView)findViewById(R.id.textView4);
        lblTitle.setText("本次计时持续"+Timee+"分钟");
        //update data
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(timeendActivity.this,UpdateActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("age",Timee);
            bundle.putString("username",User);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

}
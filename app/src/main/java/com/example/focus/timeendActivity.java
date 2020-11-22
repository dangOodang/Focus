package com.example.focus;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class timeendActivity extends AppCompatActivity {
    TextView tv=(TextView)findViewById(R.id.textView4);
    String input = getResources().getString(R.string.continuetime);
    String output = String.format(input,26);//26这里为时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeend);
    }

}
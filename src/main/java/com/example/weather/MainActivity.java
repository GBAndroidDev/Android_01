package com.example.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView headLine = findViewById(R.id.headLine);
        headLine.setText(headLine.getText() + "Vologda");

        if (savedInstanceState == null) {
            headLine.setText(headLine.getText() + "1");
        } else {
            headLine.setText(headLine.getText() + "2");
        }
    }
}
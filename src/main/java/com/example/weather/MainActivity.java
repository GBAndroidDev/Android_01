package com.example.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView headline = findViewById(R.id.headline);    // Получить элемент
        headline.setText(headline.getText() + "Vologda");      // Заменить значение
    }
}



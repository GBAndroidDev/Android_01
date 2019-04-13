package com.example.weather;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView headLine = findViewById(R.id.headLine);    // Получить элемент
        headLine.setText(headLine.getText() + "Vologda");      // Заменить значение

        if (savedInstanceState == null) {
            headLine.setText(headLine.getText() + "1");
        } else {
            headLine.setText(headLine.getText() + "2");
        }

        /*try {
            new WeatherAPI();
        } catch (IOException e) {
        }*/

        requestPermission();

        client = LocationServices.getFusedLocationProviderClient(this);


        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        client.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    TextView textView = findViewById(R.id.yourCity);
                    textView.setText(location.toString());
                }
            }
        });


        TextView yourCity = findViewById(R.id.yourCity);
        yourCity.setText("asd");
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }
}



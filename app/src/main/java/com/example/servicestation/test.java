package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test extends AppCompatActivity {

    private Button century,force,gamage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        century = findViewById(R.id.button5);
        force = findViewById(R.id.button7);
        gamage = findViewById(R.id.button6);

        century.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test.this,Century_mortors.class));
            }
        });
        force.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test.this,Force_garage.class));
            }
        });
        gamage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(test.this,Gamage_garage.class));
            }
        });
    }
}
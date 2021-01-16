package com.example.garageapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_Paralel extends AppCompatActivity {
    private Button VehicalOwner;
    private Button GarageOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__paralel);

        VehicalOwner = (Button) findViewById(R.id.button);
        GarageOwner = (Button) findViewById(R.id.button2);

        VehicalOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_Paralel();
            }
        });

        public void login_Paralel(){
            Intent intent = new Intent(this, activity_customer_map.class);
            login_Paralel(intent);
    }
        GarageOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_Paralel();
            }
        });

        public void login_Paralel(){
            Intent intent = new Intent( this, activity_driver_map.class);
            login_Paralel(intent);
        }
}
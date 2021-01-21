package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Paralel_login extends AppCompatActivity {

    private Button VehicalOwner;
    private Button GarageOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paralel_login);


        VehicalOwner = (Button) findViewById(R.id.button);
        GarageOwner = (Button) findViewById(R.id.button2);

        VehicalOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Paralel_login.this,Service_type.class));
            }
        });

        GarageOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paralel_login.this,Ownerdashbord.class));
            }
        });


    }
}
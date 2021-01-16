package com.example.servicestation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Gamage_garage extends AppCompatActivity {
    private Button Next, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamage_garage);

        Next = (Button) findViewById(R.id.button6);
        Back = (Button) findViewById(R.id.button5);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gamage_garage.this,Shedule_pickup.class));
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gamage_garage.this,Mapnew.class));
            }
            });
        }
}
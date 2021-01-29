package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gamage_garage extends AppCompatActivity {

    private Button Next, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamage_garage);

        Next = (Button) findViewById(R.id.ga_select);
        Back = (Button) findViewById(R.id.ga_back);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gamage_garage.this,Shedule_pickup.class));
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gamage_garage.this,Beforemap.class));
            }
        });
    }
}
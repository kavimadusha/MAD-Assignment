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

        Next = (Button) findViewById(R.id.button6);
        Back = (Button) findViewById(R.id.button5);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button();
            }
        });

        public void Button(){
            Gamage_garage gamage_garage = new Gamage_garage();
            gamage_garage.show(getSupportFragmentManager(), "Gamage Garaj")
        }

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gamage_garage()
            }
            public void Gamage_garage(){
                Intent intent = new Intent(this, shedule_pickup.class);
                login_Paralel(intent);
            });
        }
}
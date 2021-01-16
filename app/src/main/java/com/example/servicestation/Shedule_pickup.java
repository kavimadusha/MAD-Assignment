package com.example.servicestation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Shedule_pickup extends AppCompatActivity {
    private Button Confirmbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shedule_pickup);

        Confirmbtn = findViewById(R.id.button7);

        Confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Shedule_pickup.this,waiting_approval.class));
            }
        });
    }
}
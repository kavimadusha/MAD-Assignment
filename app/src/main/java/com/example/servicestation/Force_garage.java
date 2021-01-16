package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Force_garage extends AppCompatActivity {
    private Button Next, Back;

    private Button Next1;
    private Button Back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__paralel);

        Next1 = (Button) findViewById(R.id.button);
        Back1 = (Button) findViewById(R.id.button2);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Force_garage.this,.class));
            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Force_garage.this,.class));
            }
        });


    }
}
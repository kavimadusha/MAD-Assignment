package com.example.garageapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Force_garage extends AppCompatActivity {
    private Button Next, Back;

    @Override
    private Button Next;
    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__paralel);

        Next = (Button) findViewById(R.id.button);
        Back = (Button) findViewById(R.id.button2);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button();
            }
        });

        public void Button(){
            Finish finish = new Finish();
            Finish.show(getSupportFragmentManager(), "Gamage Garage")
        }

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Force_garage();
            }
        });

        public void Force_garage(){
            Intent intent = new Intent( this, Sheduleapickup.class);
            login_Paralel(intent);
        }
    }
}
package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Century_mortors extends AppCompatActivity {
    @Override
    private Button Next, Back;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_century_mortors);

            Next = (Button) findViewById(R.id.button6);
            Back = (Button) findViewById(R.id.button5);

            Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button();
                }
            });

            public void Button(){
                Finish finish = new Finish();
                finish.Next(getSupportFragmentManager(), "Century Motors Garage")
            }

            Back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Century_mortors();
                }
            });

            public void Century_century(){
                Intent intent = new Intent( this, Sheduleapickup.class);
                Century_century(intent);
            }
    }
}
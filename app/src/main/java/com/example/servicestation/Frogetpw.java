package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Frogetpw extends AppCompatActivity {

    private Button Privious,Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogetpw);

        Privious = (Button) findViewById(R.id.button2);
        Next = (Button) findViewById(R.id.button);

        Privious.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(Frogetpw.this,Login.class));
            }
        });

    }
}

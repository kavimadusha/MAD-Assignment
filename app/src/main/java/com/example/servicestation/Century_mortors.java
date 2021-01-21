package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Century_mortors extends AppCompatActivity {

    private Button Next, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_century_mortors);

        Next = (Button) findViewById(R.id.cm_next);
        Back = (Button) findViewById(R.id.cm_back);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Century_mortors.this,Garadge_name.class));
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Century_mortors.this,test.class));
            }
        });

    }
}

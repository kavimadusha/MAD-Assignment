package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Service_type extends AppCompatActivity {

    private CheckBox MinorService, MajorService;
    private Button  Next;
    private ArrayList<String> Result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_type);

        MinorService = findViewById(R.id.checkBox);
        MajorService = findViewById(R.id.checkBox2);
        Next = (Button) findViewById(R.id.button4);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Service_type.this,test.class));
            }
        });
    }
}
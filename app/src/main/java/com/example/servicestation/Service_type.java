package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Service_type extends AppCompatActivity {
    private CheckBox MinorService, MajorService;
    private Button LogOut, Next;
    private ArrayList<String> Result ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_type);

        MinorService = findViewById(R.id.checkBox);
        MajorService = findViewById(R.id.checkBox2);

        LogOut = (Button) findViewById(R.id.button3);
        Next = (Button) findViewById(R.id.button4);



        LogOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Service_type.this,Login.class));           }
        });


        MinorService.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
            if (MinorService.isChecked())
                Result.add("Major Service");
            else
                Result.remove("Major Service");
        }
        });

        MajorService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (MajorService.isChecked())
                    Result.add("Major Service");
                else
                    Result.remove("Minor Service");
            }
        });


        Next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Service_type.this,));
            }
        });

    }
}
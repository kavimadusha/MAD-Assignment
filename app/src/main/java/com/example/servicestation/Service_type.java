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
                Service_type();            }
        });

        public void Service_type(){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

        }

        MinorService.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
            if (MinorService.isChecked())
                Result.add("Major Service");
            else
                Result.remove(0"Major Service");
        }
        });

        MajorService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (MajorService.isChecked())
                    Result.add("Major Service");
                else
                    Result.remove(0"Minor Service");
            }
        });


        Next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Service_type();            }
        });

        public void Service_type(){
            Intent intent = new Intent(this, DriverMap.class);
            startActivity(intent);

        }





    }
}
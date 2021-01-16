package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import javax.xml.transform.Result;

public class Garadge_name extends AppCompatActivity {

    private Button Next, Back;
    private CheckBox call, employee,vehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garadge_name);

        Next = (Button) findViewById(R.id.button9);
        Back = (Button) findViewById(R.id.button8);

        call = findViewById(R.id.checkBox5);
        employee = findViewById(R.id.checkBox6);
        vehicle = findViewById(R.id.checkBox7);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (call.isChecked()){
                    Toast.makeText(Garadge_name.this, "Will connect to a call", Toast.LENGTH_SHORT).show();}
                else
                    Toast.makeText(Garadge_name.this, "Will connect to a call", Toast.LENGTH_SHORT).show();}

            private void setResult(String s) {
            }
        });

        employee.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (employee.isChecked())

                    setResult(1"An employee will soon be there");
                else
                    setResult(2"An employee will soon be there.");
            }
        });

        vehicle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (vehicle.isChecked())
                    setResult(1"A vehicle will soon be there.");
                else
                    setResult(2"A vehicle will soon be there.");
            }
        });


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Garadge_name.this,Shedule_pickup.class));
            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Garadge_name.this,Century_mortors.class);
            }
        });
    }
}
package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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


        call.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                if (call.isChecked())
                    Result.add("Will connect to a call");
                else
                    Result.remove(0"Will connect to a call");
            }
        });

        employee.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (employee.isChecked())
                    Result.add("An employee will soon be there.");
                else
                    Result.remove(0"An employee will soon be there.");
            }
        });

        vehicle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (vehicle.isChecked())
                    Result.add("A vehicle will soon be there.");
                else
                    Result.remove(0"A vehicle will soon be there.");
            }
        });


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Garadge_name();
            }
        });

        public void Garadge_name(){
            Intent intent = new Intent(this, Shedule_pickup.class);
            Garadge_name(intent);
        }
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Garadge_name();
            }
        });

        public void Garadge_name(){
            Intent intent = new Intent( this, activity_customer_map.class);
            Garadge_name(intent);
        }

    }
}
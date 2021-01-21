package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Register extends AppCompatActivity {

    private Button log_backbtn;
    private Button vo_reg;
    private Button go_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        log_backbtn = findViewById(R.id.log_backbtn);
        vo_reg = findViewById(R.id.vehiclereg_btn);
        go_reg = findViewById(R.id.gargrereg_btn);


        log_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });
        vo_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Vehicleowner_reg.class));
            }
        });
        go_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Garageowner_reg.class));
            }
        });

    }
}
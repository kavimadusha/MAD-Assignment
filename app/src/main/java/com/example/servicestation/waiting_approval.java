package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Waiting_approval extends AppCompatActivity {

    private Button wplogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_approval);
        wplogout = findViewById(R.id.wp_logout);

        wplogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Waiting_approval.this,"Logged Out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Waiting_approval.this,Login.class));
            }
        });
    }
}
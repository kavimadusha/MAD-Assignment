package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Ownerdashbord extends AppCompatActivity {

    private Button owdblogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerdashbord);

        owdblogout = findViewById(R.id.owdblogout);

        owdblogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Ownerdashbord.this,"Logged Out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Ownerdashbord.this,Login.class));
            }
        });
    }
}
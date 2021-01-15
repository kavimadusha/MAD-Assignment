   package com.example.servicestation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

   public class Login extends AppCompatActivity {

    private Button logbtn;
    private Button frogetpw;
    private Button newreg;
    private TextInputLayout l_mail;
    private TextInputLayout l_pw;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logbtn = findViewById(R.id.log_btn);
        frogetpw = findViewById(R.id.froget_pw);
        newreg = findViewById(R.id.nw_reg);
        l_mail = findViewById(R.id.l_email);
        l_pw = findViewById(R.id.l_pasword);


        auth = FirebaseAuth.getInstance();

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        frogetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        newreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }
    private void loginUser(){

        String email = l_mail.getEditText().toString();
        String pw = l_pw.getEditText().toString();
        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!pw.isEmpty()) {

                auth.signInWithEmailAndPassword(email, pw)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, Dboard.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                l_mail.setError("Empty Fields are not Allowed");
            }
        }
    }
}


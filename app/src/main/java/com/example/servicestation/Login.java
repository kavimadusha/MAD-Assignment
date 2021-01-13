   package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

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
                startActivity(new Intent(Login.this,Dboard.class));

                String email = l_mail.getEditText().toString();
                String pw = l_pw.getEditText().toString();

                loginUser(email,pw);
            }
        });
        frogetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Frogetpw.class));
                finish();
            }
        });
        newreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
                finish();
            }
        });

    }
    private void loginUser(String email,String pw){

    }
}


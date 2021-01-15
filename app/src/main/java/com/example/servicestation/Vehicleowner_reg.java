package com.example.servicestation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Vehicleowner_reg extends AppCompatActivity {

    private Button vreg_btn;
    private Button vlogback_btn;
    private Button vgargereg_btn;
    private TextInputLayout voemail, vouname, vophnum, vopw, vocpw;

    private FirebaseAuth auth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicleowner_reg);

        vreg_btn = findViewById(R.id.vowerreg_btn);
        vlogback_btn = findViewById(R.id.vlog_backbtn);
        vgargereg_btn = findViewById(R.id.v_gargereg_btn);
        voemail = findViewById(R.id.vor_emil);
        vouname = findViewById(R.id.vor_username);
        vophnum = findViewById(R.id.vor_phno);
        vopw = findViewById(R.id.vor_password);
        vocpw = findViewById(R.id.vor_cpassword);

        auth = FirebaseAuth.getInstance();

        vreg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vehicleowner_reg.this, Dboard.class));
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Vehicle owner");

                String vemail = voemail.getEditText().getText().toString();
                String vuname = vouname.getEditText().getText().toString();
                String vphnum = vophnum.getEditText().getText().toString();
                String vpw1 = vopw.getEditText().getText().toString();
                String vcpw = vocpw.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(vemail, vuname, vphnum, vpw1, vcpw);
                reference.child(vuname).setValue(helperClass);

                if (vemail.isEmpty()) {
                    voemail.setError("Email is Empty");
                    voemail.requestFocus();
                    return;
                }
                else if (vuname.isEmpty()) {
                    vouname.setError("Username is Empty");
                    vouname.requestFocus();
                    return;
                }
               else if (vphnum.isEmpty()) {
                    vophnum.setError("Phone Number is Empty");
                    vophnum.requestFocus();
                    return;
                }
               else if (vpw1.isEmpty()) {
                    vopw.setError("Password is Empty");
                    vopw.requestFocus();
                    return;
                }
               else if (vcpw.isEmpty()) {
                    vocpw.setError("Confirm Password is Empty");
                    vocpw.requestFocus();
                    return;
                }
               else if (vopw.equals(vocpw)) {
                    Toast.makeText(Vehicleowner_reg.this, "Password is not matched", Toast.LENGTH_SHORT).show();
                    vocpw.requestFocus();
                    vopw.requestFocus();
                    return;
                }
               else if (!Patterns.EMAIL_ADDRESS.matcher(vemail).matches()) {
                    voemail.setError("Please Enter Valid Email");
                    voemail.requestFocus();
                    return;
                }
               else if (vcpw.length() < 6) {
                    vopw.setError("Minimum Password Length should be 6 Characters");
                    vopw.requestFocus();
                    return;
                } else {
                    registerUser(vemail, vuname, vphnum, vpw1, vcpw);
                    Toast.makeText(Vehicleowner_reg.this, "User has been Registered Successfully", Toast.LENGTH_LONG).show();
                }
            }
        });
        vlogback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vehicleowner_reg.this, Login.class));
            }
        });
        vgargereg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vehicleowner_reg.this, Garageowner_reg.class));
            }
        });
    }

    private void registerUser(String vemail, String vuname, String vphnum, String vpw1, String vcpw) {

        auth.createUserWithEmailAndPassword(vemail,vpw1).addOnCompleteListener(Vehicleowner_reg.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
           if (task.isSuccessful()){
               Toast.makeText(Vehicleowner_reg.this,"Registration Successful",Toast.LENGTH_LONG).show();
           }else {
               Toast.makeText(Vehicleowner_reg.this,"Registration Failed",Toast.LENGTH_LONG).show();
           }
            }
        });
    }
}
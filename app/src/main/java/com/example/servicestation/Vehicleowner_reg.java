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

                    registerUser();
                }

        });
        vlogback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vehicleowner_reg.this, Login.class));
                finish();
            }
        });
        vgargereg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vehicleowner_reg.this, Garageowner_reg.class));
                finish();
            }
        });
    }

    private void registerUser() {
        String vemail = voemail.getEditText().getText().toString();
        String vuname = vouname.getEditText().getText().toString();
        String vphnum = vophnum.getEditText().getText().toString();
        String vpw1 = vopw.getEditText().getText().toString();
        String vcpw = vocpw.getEditText().getText().toString();

        if (vemail.isEmpty()) {
            voemail.setError("Email is Empty");
            voemail.requestFocus();
            return;
        }
        if (vuname.isEmpty()) {
            vouname.setError("Username is Empty");
            vouname.requestFocus();
            return;
        }
        if (vphnum.isEmpty()) {
            vophnum.setError("Phone Number is Empty");
            vophnum.requestFocus();
            return;
        }
        if (vpw1.isEmpty()) {
            vopw.setError("Password is Empty");
            vopw.requestFocus();
            return;
        }
        if (vcpw.isEmpty()) {
            vocpw.setError("Confirm Passwor is Empty");
            vocpw.requestFocus();
            return;
        }
        if (!vopw.equals(vocpw)) {
            Toast.makeText(Vehicleowner_reg.this, "Password is not matched", Toast.LENGTH_SHORT).show();
            vocpw.requestFocus();
            vopw.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(vemail).matches()){
            voemail.setError("Please Enter Valid Email");
            voemail.requestFocus();
            return;
        }
        if (vcpw.length()<6){
            vopw.setError("Minimum Password Length should be 6 Characters");
            vopw.requestFocus();
            return;
        }
        vreg_btn.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(vemail,vpw1)
                .addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        if(task.isSuccessful()){
                            UserHelperClass helperClass = new UserHelperClass(vemail, vuname, vphnum, vpw1, vcpw);

                            rootNode = FirebaseDatabase.getInstance();

                            FirebaseDatabase.getInstance().getReference("Vehicle owner")
                                 .setValue(helperClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                             @Override
                             public void onComplete(@NonNull Task<Void> task) {
                                 if(task.isSuccessful()){
                                     Toast.makeText(Vehicleowner_reg.this,"User has been Registered Successfult",Toast.LENGTH_LONG).show();
                                     vreg_btn.setVisibility(View.GONE);

                                 }else {
                                     Toast.makeText(Vehicleowner_reg.this,"Failed to Register",Toast.LENGTH_LONG).show();
                                     vreg_btn.setVisibility(View.VISIBLE);

                                 }
                             }
                         });

                        }else{
                            Toast.makeText(Vehicleowner_reg.this,"Failed to Register",Toast.LENGTH_LONG).show();
                            vreg_btn.setVisibility(View.VISIBLE);
                        }
                    }
                });

    }
}
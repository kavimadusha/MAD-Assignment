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
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Garageowner_reg extends AppCompatActivity {

    private Button greg_btn;
    private Button glogback_btn;
    private Button gvehiclereg_btn;
    private TextInputLayout goemail,goname,gophnum,gopw,gocpw;

    private FirebaseAuth authm;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garageowner_reg);

        greg_btn = findViewById(R.id.greg_btn);
        glogback_btn = findViewById(R.id.glog_backbtn);
        gvehiclereg_btn = findViewById(R.id.g_vehiclereg_btn);
        goemail = findViewById(R.id.gor_emil);
        goname = findViewById(R.id.gor_username);
        gophnum = findViewById(R.id.gor_phno);
        gopw = findViewById(R.id.gor_password);
        gocpw = findViewById(R.id.gor_cpassword);

        authm = FirebaseAuth.getInstance();


        greg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Garageowner_reg.this,Dboard.class));
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Garage owner");

                String gemail = goemail.getEditText().getText().toString();
                String gname = goname.getEditText().getText().toString();
                String gphnum = gophnum.getEditText().getText().toString();
                String gpw = gopw.getEditText().getText().toString();
                String gcpw = gocpw .getEditText().getText().toString();

                UserHelperClass2 helperClass2 = new UserHelperClass2(gemail,gname,gphnum,gpw,gcpw);
                reference.child(gname).setValue(helperClass2);

                if (gemail.isEmpty()) {
                    goemail.setError("Email is Empty");
                    goemail.requestFocus();
                    return;
                }
               else if (gname.isEmpty()) {
                    goname.setError("Username is Empty");
                    goname.requestFocus();
                    return;
                }
               else if (gphnum.isEmpty()) {
                    gophnum.setError("Phone Number is Empty");
                    gophnum.requestFocus();
                    return;
                }
               else if (gpw.isEmpty()) {
                    gopw.setError("Password is Empty");
                    gopw.requestFocus();
                    return;
                }
               else if (gcpw.isEmpty()) {
                    gocpw.setError("Confirm Passwor is Empty");
                    gocpw.requestFocus();
                    return;
                }
               else if (gopw.equals(gocpw)) {
                    Toast.makeText(Garageowner_reg.this, "Password is not matched", Toast.LENGTH_SHORT).show();
                    gocpw.requestFocus();
                    gopw.requestFocus();
                    return;
                }
               else if (!Patterns.EMAIL_ADDRESS.matcher(gemail).matches()) {
                    goemail.setError("Please Enter Valid Email");
                    goemail.requestFocus();
                    return;
                }
                else if (gcpw.length() < 6) {
                    gopw.setError("Minimum Password Length should be 6 Characters");
                    gopw.requestFocus();
                    return;
                }
                else {
                        registerUser(gemail,gname,gphnum,gpw,gcpw);
                    Toast.makeText(Garageowner_reg.this,"User has been Registered Successfully",Toast.LENGTH_LONG).show();

                }
            }
        });
        glogback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Garageowner_reg.this,Login.class));
            }
        });
        gvehiclereg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Garageowner_reg.this,Vehicleowner_reg.class));
            }
        });
    }
    private void registerUser(String gemail, String gname, String gphnum, String gpw, String gcpw) {
        authm.createUserWithEmailAndPassword(gemail,gpw).addOnCompleteListener(Garageowner_reg.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Garageowner_reg.this,"Registration Successful",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Garageowner_reg.this,"Registration Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

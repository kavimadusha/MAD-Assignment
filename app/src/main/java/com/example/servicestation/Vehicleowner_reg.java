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
    private TextInputLayout voemail,vouname,vophnum,vopw,vocpw;

    private FirebaseAuth auth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private Object AuthResult;


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
                startActivity(new Intent(Vehicleowner_reg.this,Dboard.class));
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Vehicle owner");

                String vemail = voemail.getEditText().getText().toString();
                String vuname = vouname.getEditText().getText().toString();
                String vphnum = vophnum.getEditText().getText().toString();
                String vpw1 = vopw.getEditText().getText().toString();
                String vcpw = vocpw .getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(vemail,vuname,vphnum,vpw1,vcpw);
                reference.child(vuname).setValue(helperClass);

                if (TextUtils.isEmpty(vemail)||TextUtils.isEmpty(vuname)||TextUtils.isEmpty(vphnum)||TextUtils.isEmpty(vpw1)||TextUtils.isEmpty(vcpw)){
                    Toast.makeText(Vehicleowner_reg.this,"Please fill in all input files",Toast.LENGTH_SHORT).show();
                }
                else if (vpw1.length()<7){
                    Toast.makeText(Vehicleowner_reg.this,"Password should be strong",Toast.LENGTH_SHORT).show();
                }
                else if (!vpw1.equals(vcpw)){
                    Toast.makeText(Vehicleowner_reg.this,"Password is not matched",Toast.LENGTH_SHORT).show();

                }
                else {
                    registerUser(vemail,vuname,vphnum,vpw1,vcpw);
                }
            }
        });
        vlogback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vehicleowner_reg.this,Login.class));
                finish();
            }
        });
        vgargereg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vehicleowner_reg.this,Garageowner_reg.class));
                finish();
            }
        });
    }
    private void registerUser(String vemail, String vuname, String vphnum, String vpw1, String vcpw) {

    }
}
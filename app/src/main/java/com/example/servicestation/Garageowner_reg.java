 package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Garageowner_reg extends AppCompatActivity {

    private Button greg_btn;
    private Button glogback_btn;
    private Button gvehiclereg_btn;
    private TextInputLayout goemail,goname,gophnum,gopw,gocpw;


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

                if (TextUtils.isEmpty(gemail)||TextUtils.isEmpty(gname)||TextUtils.isEmpty(gphnum)||TextUtils.isEmpty(gpw)||TextUtils.isEmpty(gcpw)){
                    Toast.makeText(Garageowner_reg.this,"Please fill in all input files",Toast.LENGTH_SHORT).show();
                }
                else if (gpw.length()<7){
                    Toast.makeText(Garageowner_reg.this,"Password should be strong",Toast.LENGTH_SHORT).show();
                }
                else if (!gpw.equals(gcpw)){
                    Toast.makeText(Garageowner_reg.this,"Password is not matched",Toast.LENGTH_SHORT).show();
                }
                else {
                        registerUser(gemail,gname,gphnum,gpw,gcpw);
                }
            }
        });
        glogback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Garageowner_reg.this,Login.class));
                finish();
            }
        });
        gvehiclereg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Garageowner_reg.this,Vehicleowner_reg.class));
                finish();
            }
        });
    }
    private void registerUser(String gemail, String gname, String gphnum, String gpw, String gcpw) {
    }
}

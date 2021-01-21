package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Gardge_info extends AppCompatActivity {

    private Button summitbtn, logoutbtn;
    private TextInputLayout g_name, g_des, g_address, g_pnum, g_owetails, g_noofemp;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardge_info);

        g_name = findViewById(R.id.gname);
        g_des = findViewById(R.id.gdescription);
        g_address = findViewById(R.id.gaddress);
        g_pnum = findViewById(R.id.gphonnum);
        g_owetails = findViewById(R.id.gownerdetails);
        g_noofemp = findViewById(R.id.gnoofemp);
        summitbtn = findViewById(R.id.gsubmit_btn);
        logoutbtn = findViewById(R.id.button10);

        reference = FirebaseDatabase.getInstance().getReference().child("Garage_Information");

        summitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Gardge_info.this, Ownerdashbord.class));
                addinfo();
            }
        });
    }

    private void addinfo() {

        String garagename = g_name.getEditText().getText().toString();
        String description = g_des.getEditText().getText().toString();
        String address = g_address.getEditText().getText().toString();
        String phonenumber = g_pnum.getEditText().getText().toString();
        String ownerinfo = g_owetails.getEditText().getText().toString();
        String nofemp = g_noofemp.getEditText().getText().toString();

        if (TextUtils.isEmpty(garagename) || TextUtils.isEmpty(description) || TextUtils.isEmpty(address) || TextUtils.isEmpty(phonenumber) || TextUtils.isEmpty(ownerinfo) || TextUtils.isEmpty(nofemp)) {
            Toast.makeText(Gardge_info.this, "Please fill all the Information", Toast.LENGTH_SHORT).show();
        } else {
            UserHelperClass3 helperClass3 = new UserHelperClass3(garagename, description, address, phonenumber, ownerinfo, nofemp);
            reference.push().setValue(helperClass3);
            Toast.makeText(Gardge_info.this, "Data Inserted", Toast.LENGTH_SHORT).show();

        }
    }
}

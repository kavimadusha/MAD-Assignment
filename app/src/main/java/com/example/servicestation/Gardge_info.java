package com.example.servicestation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Gardge_info extends AppCompatActivity {

    private Button summitbtn ;
    private EditText textView24,textView25,textView36,textView37,textView38,textView39;

    private FirebaseAuth authw;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardge_info);

        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView36 = findViewById(R.id.textView36);
        textView37 = findViewById(R.id.textView37);
        textView38 = findViewById(R.id.textView38);
        textView39 = findViewById(R.id.textView39);
        summitbtn = findViewById(R.id.button11);

        summitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Gardge_info.this,Mapnew.class));
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Garage Information");

                String garagename = textView24.getText().toString();
                String Description = textView25.getText().toString();
                String address = textView36.getText().toString();
                String phonenumber = textView37.getText().toString();
                String ownerinfo = textView38.getText().toString();
                String nofemp = textView39.getText().toString();

                UserHelperClass3 helperClass3 = new UserHelperClass3(garagename, Description, address, phonenumber, ownerinfo, nofemp);
                reference.child(garagename).setValue(helperClass3);

                if (TextUtils.isEmpty(garagename) || TextUtils.isEmpty(Description) || TextUtils.isEmpty(address) || TextUtils.isEmpty(phonenumber) || TextUtils.isEmpty(ownerinfo) || TextUtils.isEmpty(nofemp)) {
                    Toast.makeText(Gardge_info.this, "Please fill all the Information", Toast.LENGTH_SHORT).show();
                } else {
                    addinfo(garagename, Description, address, phonenumber, ownerinfo, nofemp);
                }
            }


        });
    }
            private  void addinfo(String gname,String des,String address, String Pnum, String Owninfo,String noofemp ) {

            }
    }

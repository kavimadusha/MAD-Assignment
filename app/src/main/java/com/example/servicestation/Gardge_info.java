package com.example.servicestation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Gardge_info extends AppCompatActivity {

    private Button summitbtn ;
    private EditText textView24,textView25,textView36,textView37,textView38,textView39;

    private FirebaseAuth authm;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardge_info);


           textView24= findViewById(R.id.textView24);
           textView25= findViewById(R.id.textView25);
           textView36= findViewById(R.id.textView36);
           textView37= findViewById(R.id.textView37);
           textView38= findViewById(R.id.textView38);
           textView39= findViewById(R.id.textView39);
           summitbtn= findViewById(R.id.button11);

            summitbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Gardge_info.this,.class));
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("Garage Information");

                    String garagename = textView24.getText().toString();
                    String Description = textView25.getText().toString();
                    String address = textView36.getText().toString();
                    String phonenumber = textView37.getText().toString();
                    String ownerinfo = textView38.getText().toString();
                    String nofemp = textView39.getText().toString();
                }
            });




        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==1 && requestCode==RESULT_OK && data!=null && data.getData()!==null)
            {
                imaguri=data.getData();
                img.setImageURI(imguri);
            }
        }
    };
}

    public void addOwners(){
        String garagename = textView24.getText().toString();
        String Description = textView25.getText().toString();
        String address = textView36.getText().toString();
        String phonenumber = textView37.getText().toString();
        String ownerinfo = textView38.getText().toString();
        String nofemp = textView39.getText().toString();

        if(!TextUtils.isEmpty(garagename) && !TextUtils.isEmpty(Description) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(phonenumber) && !TextUtils.isEmpty(ownerinfo) && !TextUtils.isEmpty(nofemp)){

            owners owners = new owners(garagename,Description,address,phonenumber,ownerinfo,nofemp);
            databaseReference.garagename.setText("");
            Description.setText("");
            address.setText("");
            phonenumber.setText("");
            ownerinfo.setText("");
            nofemp.setText("");


        }
        else {
            Toast.makeText( context: MainActivity.this, text: "Please fill all the informations", Toast.LENGTH_LONG).show()
        }
    }
    }
}
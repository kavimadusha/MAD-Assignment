package com.example.garage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    private EditText textView24;
    private Button button11 = (button)findViewById(R.id.button11);
    private EditText textView25,textView36,textView37,textView38,textView39;
    ImageView imageView15;
    public Uri imguri;

    DatabaseReference databaseReference;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        databaseReference = FirebaseDatabase.getInstance().getReferance( = "Owners");

        textView24 = (EditText) findViewById(R.id.textView24);
        textView25 = (EditText) findViewById(R.id.textView25);
        textView36 = (EditText) findViewById(R.id.textView36);
        textView38 = (EditText) findViewById(R.id.textView38);
        textView39 = (EditText) findViewById(R.id.textView39);
        textView37 = (EditText) findViewById(R.id.textView37);
        imageView15 = (ImageView) findViewById(R.id.imageView15);
        button button10 = (button) findViewById((R.id.button10));

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOwners();
                Filechooser();
            }
        });
        up.setOnClickListner(new View.OnClickListener()
            @Override
            public void onClick(View view){
                Fileuploader();
        });
    }

    private String getExtension(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return  mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }
    private void Fileuploader(
    {
        
    }
    )

    private void Filechooser() {
                Intent intent = new Intent();
                intent.setType("image/'");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, requestCode, 1);
                        
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
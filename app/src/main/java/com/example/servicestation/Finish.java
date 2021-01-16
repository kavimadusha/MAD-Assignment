package com.example.garageapp2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Finish extends AppCompatActivity {
    @Override
    public Dialog Finish (Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getCallingActivity());
        builder.setTitle("Information")
                .setMessage("Thanks For Your Support. A masage will be delivered when the service is delivered!")
                .setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }

                    public void Service_type(){
                        Intent intent = new Intent(this, Login.class);
                        startActivity(intent);

                    }
                });

    }
                    return builder.create();
});
        }
        }

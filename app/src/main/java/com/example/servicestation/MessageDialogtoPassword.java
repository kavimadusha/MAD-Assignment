package com.example.servicestation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MessageDialogtoPassword extends AppCompatActivity {
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Information")
                .setMessage("Check Your email to continue!")
                .setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            Service_type();            }
                    });

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

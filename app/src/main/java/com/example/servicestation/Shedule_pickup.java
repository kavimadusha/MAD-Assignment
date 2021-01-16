package com.example.servicestation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Shedule_pickup extends AppCompatActivity {
    private Button logbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shedule_pickup);

        logbtn = findViewById(R.id.button7);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( packageContenxt: Shedule_pickup.this.century.class);
                startActivity(intent);
            }
        });



            }
        })
    }
}
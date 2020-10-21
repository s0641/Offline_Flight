package com.app.gohigh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlightAdmin extends AppCompatActivity {

    Button b, add;
    //private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_admin);

        b = findViewById(R.id.ad);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightAdmin.this, Admin.class);
                startActivity(intent);
            }
        });

        add = findViewById(R.id.add_flight);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlightAdmin.this, Flow.class);
                startActivity(intent);
            }
        });
    }
}

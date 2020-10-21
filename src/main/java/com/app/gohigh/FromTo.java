package com.app.gohigh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FromTo extends AppCompatActivity
{

    private Button go;
    private EditText from;
    private EditText to;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_to);

        go = findViewById(R.id.go);
        from = findViewById(R.id.from);
        to = findViewById(R.id.to);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(FromTo.this,Flow.class);
                startActivity(intent);
            }
        });

    }

}
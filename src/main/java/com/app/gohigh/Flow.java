package com.app.gohigh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Flow extends AppCompatActivity {
    EditText e1,e2,e3;
    DatabaseHelper db;

    Button sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        db=new DatabaseHelper(this);
        e1=findViewById(R.id.add_id);
        e2=findViewById(R.id.add_From);
        e3=findViewById(R.id.add_to);
        sa=findViewById(R.id.btn_nxt);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(e1.getText().toString());
                String ff=e2.getText().toString();
                String tt=e3.getText().toString();
                long res=db.insertNote(id,ff,tt);

                Toast.makeText(getApplicationContext(),"Flight added Successfully"+res,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Flow.this, Faltu.class);
                Cursor cursor=db.getData();
                if(cursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while(cursor.moveToNext())
                    {
                        //Toast.makeText(getApplicationContext(),"Id "+cursor.getString(0),Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),"From "+cursor.getString(1),Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),"To "+cursor.getString(2),Toast.LENGTH_LONG).show();
                    }
                }
                /*intent.putExtra("value",Integer.toString(id));
                intent.putExtra("Depppp",ff);
                intent.putExtra("Arrrrr",tt);*/
                startActivity(intent);
            }
        });


    }

}
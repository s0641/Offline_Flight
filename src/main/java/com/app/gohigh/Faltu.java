package com.app.gohigh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Faltu extends AppCompatActivity {
    TextView  show,show1,show2;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltu);
        show=findViewById(R.id.shhhhh);
        show1=findViewById(R.id.ssssii);
        show2=findViewById(R.id.ssssttt);
        db=new DatabaseHelper(this);

        Cursor cursor=db.getData();
        show.setText("");
        while(cursor.moveToNext())
        {
            show.append(cursor.getString(0));
            show1.append(cursor.getString(1));
            show2.append(cursor.getString(2));
        }

        /*Intent i = getIntent();
        String s1= i.getStringExtra("value");
        String s2= i.getStringExtra("Depppp");
        String s3= i.getStringExtra("Arrrrr");
        show.setText("\n" +s1+"\n"+s2+"\n"+s3);*/

    }
}
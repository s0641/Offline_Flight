package com.app.gohigh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";



    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT)");
        System.out.println(Passengers.CREATE_TABLE);
        sqLiteDatabase.execSQL(Passengers.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Passengers.TABLE_DUO);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return  res;
    }

    public long insertNote(int id,String From, String To) {
        // get writable database as we want to write data

        System.out.println(Passengers.TABLE_DUO);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Passengers.COLUMN_ID,id);
        contentValues.put(Passengers.COLUMN_FROM,From);
        contentValues.put(Passengers.COLUMN_TO,To);
        System.out.println(id+" "+From+" "+To);
        long res = db.insert(Passengers.TABLE_DUO,null,contentValues);
        System.out.println(res);
        db.close();
        return res;
    }

    /*public Passengers findUser() {

        String query = "select * from " + Passengers.TABLE_DUO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Passengers user = new Passengers();
        if (cursor.moveToFirst()) {

            user.getBooking_Id(cursor.getString(0));
            user.getFrom_place(cursor.getString(1));
            user.getTo_place(cursor.getString(2));
            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;
    }*/

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery( "select * from flop", null );
        return res;
    }


    public boolean checkUser(String username, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }
    public boolean checkUser_register(String username){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs, null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }
}

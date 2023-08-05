package com.example.onlineshopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

     public static final String DBNAME = "Login.db";

    public DBHelper( Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        MyDB.execSQL("CREATE TABLE users(username TEXT primary key,email TEXT,password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {

        MyDB.execSQL("drop table if exists users");

    }

    public Boolean insertData(String username,String email,String password){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = MyDB.insert("users",null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

        //check username

    public Boolean checkUsername(String username) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    //check email

    public Boolean checkEmail(String email) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where email = ?",new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    //check password

    public Boolean checkEmailPassword(String email,String password){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where email = ? and password = ?",new String[] {email,password});
        if (cursor.getCount()>0 )
            return true;
        else
            return false;

    }

}

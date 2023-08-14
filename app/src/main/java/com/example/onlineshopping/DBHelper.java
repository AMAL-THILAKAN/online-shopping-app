package com.example.onlineshopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    public static final String PRODUCT_TABLE_NAME = "Products";
    public static final String ITEM_NAME = "ItemName";
    public static final String ITEM_DESC_NAME = "ItemDesName";
    public static final String ITEM_PRICE = "ItemPrice";
    public static final String ITEM_ID = "_id";

    private static final String[] INITIAL_PRODUCTS = {"Alice", "Bob", "Charlie"};

    public List<Item> items = new ArrayList<>();

    public DBHelper( Context context) {

        super(context, "Login.db", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {

        Log.i("DB", "************************** EXECUTING ONCREATE *************************");

        items.add(new Item("Knight Owl (Caldecott Honor Book)",
                "by Christopher Denise (Author)", "RS 1189.53", R.drawable.book1));
        items.add(new Item("The Marvellers (The Conjureverse, 1)",
                "by Dhonielle Clayton (Author))", "RS 750.00", R.drawable.book2));
        items.add(new Item("BEILU Mens Long Sleeve Dress Shirt",
                "Mens shirts", "RS 20655.00", R.drawable.cloth1));
        items.add(new Item("Mens Suit Vests Formal V-Neck Vest Dress",
                "Men's Waistcoat", "price = RS 2561.76", R.drawable.clothe2));
        items.add(new Item("JBL Tune 230NC TWS",
                "True Wireless In-Ear Noise Cancelling Headphones", "RS 8262.00", R.drawable.electronics1));
        items.add(new Item("SAMSUNG Galaxy Watch",
                "smart watch by samsung", "Rs 18873.00", R.drawable.electronics2));
        items.add(new Item("Hydro Flask",
                "Wide Mouth Bottle with Flex Cap", "RS 3674.41", R.drawable.homeapp1));
        items.add(new Item("OVENTE Glass Electric Kettle ",
                "1.5 Liter Borosilicate Glass Fast Boiling", "RS 1239.13", R.drawable.homeapp2));

        String createTableQuery = "CREATE TABLE " + PRODUCT_TABLE_NAME +
                "(" + ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ITEM_NAME + " TEXT, " + ITEM_DESC_NAME + " TEXT, " +
                ITEM_PRICE + " TEXT)";

        MyDB.execSQL(createTableQuery);

        // Insert initial data if table is empty
        Log.i("DB", "**************************PRODUCT TABLE CHECKING IF *************************");
        if (isTableEmpty(MyDB)) {
            Log.i("DB", "**************************PRODUCT TABLE CREATING*************************");
            insertInitialData(MyDB);
        }

        MyDB.execSQL("CREATE TABLE users(username TEXT primary key,email TEXT,password TEXT )");
//        MyDB.execSQL("create table Products(product_name TEXT primary key,description TEXT ,PRICE TEXT)");

    }

    // Helper method to check if the table is empty
    private boolean isTableEmpty(SQLiteDatabase db) {

        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + PRODUCT_TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getInt(0);
            cursor.close();
            return count == 0;
        }
        return true;
    }

    // Helper method to insert initial data
    public void insertInitialData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        for (Item item : items) {

            values.put(ITEM_NAME, item.item_name);
            values.put(ITEM_DESC_NAME, item.description);
            values.put(ITEM_PRICE, item.price);

            db.insert(PRODUCT_TABLE_NAME, null, values);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {

        MyDB.execSQL("drop table if exists users");
        MyDB.execSQL("drop table if exists products");

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

package com.bignerdranch.android.personaltrainerportal2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Gloec on 9/25/2017.
 */

public class ContactsTable {

    DatabaseHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

            public ContactsTable(Context context){
                dbHelper = new DatabaseHelper(context);
            }
            public void openDB(){
                sqLiteDatabase = dbHelper.getWritableDatabase();
            }
            public void closeDB(){
                sqLiteDatabase.close();
            }
            public void insertRecord(String cname,String caddress,String cphone){
                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.COL_NAME,cname);
                contentValues.put(DatabaseHelper.COL_ADDRESS,caddress);
                contentValues.put(DatabaseHelper.COL_PHONE,cphone);

                sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
            }

            public Cursor getAllRecords(){
                return sqLiteDatabase.rawQuery("select * from "+DatabaseHelper.TABLE_NAME,null);
            }


}

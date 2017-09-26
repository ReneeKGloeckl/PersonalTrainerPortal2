package com.bignerdranch.android.personaltrainerportal2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Gloec on 9/23/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="contactsdb";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "contacts";
    public static final String COL_ID = "cid";
    public static final String COL_NAME = "cname";
    public static final String COL_ADDRESS = "caddress";
    public static final String COL_PHONE = "cphone";

    String CREATE_CTABLE = "create table contacts(cid INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "cname text,caddress text,cphone text )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CTABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

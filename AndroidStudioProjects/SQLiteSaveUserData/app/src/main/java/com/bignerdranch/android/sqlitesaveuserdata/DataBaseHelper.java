package com.bignerdranch.android.sqlitesaveuserdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by Gloec on 9/26/2017.
 */


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATA_BASE = "people.db";
    public static final String TABLE_NAME= "people_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "EMAIL";
    public static final String COL4= "PHONE";

    public DataBaseHelper(Context context) {
        super(context, DATA_BASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE_TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " NAME TEXT, EMAIL TEXT, PHONE TEXT)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

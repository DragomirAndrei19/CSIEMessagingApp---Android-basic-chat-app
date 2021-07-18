package com.example.csiemessagingappv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/// Special class created for handling the database

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "bugreports.db";
    public static final String TABLE_NAME = "bugreports_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "COUNTRY";
    public static final String COL_4 = "PROBLEM";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("create table " + TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, COUNTRY TEXT, PROBLEM TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(sqLiteDatabase);
    }

    public boolean insertData(String email, String country, String problem) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, country);
        contentValues.put(COL_4, problem);
        long result =sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor theResult = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return theResult;
    }

    public boolean updateTheData(String id, String email, String country, String problem) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, country);
        contentValues.put(COL_4, problem);
        sqLiteDatabase.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }

    // For custom report
    public Cursor getCustomData(String currentCountry) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor theResult = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE country = ?", new String[] {currentCountry});

        return theResult;
    }

    public Cursor getDataById(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME + " where id = ?", new String[] {String.valueOf(id)});
        return res;
    }

}

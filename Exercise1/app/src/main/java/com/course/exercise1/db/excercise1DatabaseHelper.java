package com.course.exercise1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 04/05/2016.
 */
public class excercise1DatabaseHelper extends SQLiteOpenHelper {

    private static final int DataBase_Version = 1;
    private static final String DataBase_Name ="exercise1.db";

    private static final String SQL_Creation = "Create table " + exercise1Contract.fiveFactsEntry.Table_Name
            + " ( "
            +exercise1Contract.fiveFactsEntry._ID+ " INTEGER PRIMARY KEY"
            +exercise1Contract.fiveFactsEntry.COLUMN_FACT_NUMBER + "INTEGER"
            +exercise1Contract.fiveFactsEntry.COLUMN_FACT + "TEXT"
            + ")";


    public excercise1DatabaseHelper(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_Creation);
       // createInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //todo in next version
    }


}

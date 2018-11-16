package fr.rennes.clicklunch.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import fr.rennes.database.Helper.DBHelperBase;

public class DatabaseHelper extends DBHelperBase {

    public static String DATABASE_NAME = "ClickLunch";
    public static int DATABASE_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package kr.aleks.project_1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConstrBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "constrBase.db";

    public ConstrBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL("create table " + ConstrTable.CONSTR_NAME + "(" +
                " _id integer primary key autoincrement, " +
                ConstrTable.Cols.UUID + ", " +
                ConstrTable.Cols.TITLE + ", " +
                ConstrTable.Cols.GROWTH + ", " +
                ConstrTable.Cols.DESCRIPTION + ", " +
                ConstrTable.Cols.PLUS_THE_INCREASE + ", " +
                ConstrTable.Cols.TIMER
        );*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

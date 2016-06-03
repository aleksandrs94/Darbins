package com.example.kriss.galadarbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.DropBoxManager;
import android.util.Log;


public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SLUD_INFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ Pievienot.JaunaSludInfo.TABLE_NAME+ "(" + Pievienot.JaunaSludInfo.NOSAUKUMS+" TEXT NOT NULL, "+
                    Pievienot.JaunaSludInfo.VIETA+" TEXT NOT NULL, "+ Pievienot.JaunaSludInfo.DATUMS+" TEXT NOT NULL, "+
                    Pievienot.JaunaSludInfo.CENA+" TEXT NOT NULL, "+ Pievienot.JaunaSludInfo.INFO+" TEXT NOT NULL);";
    private static final String DROP_TABLE =
            "DROP TABLE "+ Pievienot.JaunaSludInfo.TABLE_NAME;

    public UserDBHelper(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATION", "Database created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION", "Table created...");
    }

    public void addInformations (String nosaukums, String vieta, String datums, String cena, String info, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Pievienot.JaunaSludInfo.NOSAUKUMS, nosaukums);
        contentValues.put(Pievienot.JaunaSludInfo.VIETA, nosaukums);
        contentValues.put(Pievienot.JaunaSludInfo.DATUMS, datums);
        contentValues.put(Pievienot.JaunaSludInfo.CENA, cena);
        contentValues.put(Pievienot.JaunaSludInfo.INFO, info);
        db.insert(Pievienot.JaunaSludInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATION", "One row insert...");
        //db.execSQL(DROP_TABLE);
        //Log.e("DATABASE OPERATION", "Table dropped...");
    }

    public Cursor getInformations (SQLiteDatabase db)
    {

        Cursor cursor;
            String[] projections = {Pievienot.JaunaSludInfo.NOSAUKUMS, Pievienot.JaunaSludInfo.VIETA,
                    Pievienot.JaunaSludInfo.DATUMS, Pievienot.JaunaSludInfo.CENA, Pievienot.JaunaSludInfo.INFO};

            cursor = db.query(Pievienot.JaunaSludInfo.TABLE_NAME, projections, null, null, null, null, null);
            return cursor;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.kriss.galadarbs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class DataListActivity extends Activity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDBHelper userDBHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        listView = (ListView)findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDBHelper = new UserDBHelper(getApplicationContext());
        sqLiteDatabase = userDBHelper.getReadableDatabase();
        cursor = userDBHelper.getInformations(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String nosaukums;
                String vieta, datums, cena, info;

                nosaukums = cursor.getString(0);
                vieta = cursor.getString(1);
                datums = cursor.getString(2);
                cena = cursor.getString(3);
                info = cursor.getString(4);
                DataProvider dataProvider = new DataProvider(nosaukums, vieta, datums, cena, info);
                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());

        }

    }

    public void openSludinajums(View view)
    {
        Intent intent = new Intent(DataListActivity.this,Main_Activity.class);
        startActivity(intent);
    }
}


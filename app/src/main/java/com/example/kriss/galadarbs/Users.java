package com.example.kriss.galadarbs;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//ir
public class Users extends Activity {
    EditText Nosaukums, Datums, Cena, Info;
    Context context = this;
    UserDBHelper userDBHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Nosaukums = (EditText) findViewById(R.id.slud_nosaukums);
        Datums = (EditText) findViewById(R.id.slud_datums);
        Cena = (EditText) findViewById(R.id.slud_cena);
        Info = (EditText) findViewById(R.id.slud_info);
    }

    public void addSludinajums(View view)
    {
        String nosaukums = Nosaukums.getText().toString();
        String datums = Datums.getText().toString();
        String cena = Cena.getText().toString();
        String info = Info.getText().toString();
        userDBHelper = new UserDBHelper(context);
        sqLiteDatabase = userDBHelper.getWritableDatabase();
        userDBHelper.addInformations(nosaukums,datums,cena,info,sqLiteDatabase);
        Nosaukums.setText("");
        Datums.setText("");
        Cena.setText("");
        Info.setText("");
        Info.clearFocus();
        Toast.makeText(getBaseContext(),"Dati Saglabati",Toast.LENGTH_LONG).show();
            userDBHelper.close();
    }
}

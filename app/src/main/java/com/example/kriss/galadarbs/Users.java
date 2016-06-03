package com.example.kriss.galadarbs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Users extends Activity {
    EditText Nosaukums, Vieta, Datums, Cena, Info;
    Context context = this;
    UserDBHelper userDBHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        Nosaukums = (EditText) findViewById(R.id.slud_nosaukums);
        Vieta = (EditText) findViewById(R.id.slud_vieta);
        Datums = (EditText) findViewById(R.id.slud_datums);
        Cena = (EditText) findViewById(R.id.slud_cena);
        Info = (EditText) findViewById(R.id.slud_info);
    }

    public void addSludinajums(View view)
    {
        if( Nosaukums.getText().toString().trim().equals("") || Vieta.getText().toString().trim().equals("")
                || Datums.getText().toString().trim().equals("")|| Cena.getText().toString().trim().equals("")
                || Info.getText().toString().trim().equals(""))
        {
            Toast.makeText(getBaseContext(),"Visiem laukiem jabut aizpilditiem",Toast.LENGTH_LONG).show();
        }
        else{
            String nosaukums = Nosaukums.getText().toString();
            String vieta = Vieta.getText().toString();
            String datums = Datums.getText().toString();
            String cena = Cena.getText().toString();
            String info = Info.getText().toString();
            userDBHelper = new UserDBHelper(context);
            sqLiteDatabase = userDBHelper.getWritableDatabase();
            userDBHelper.addInformations(nosaukums, vieta, datums,cena,info,sqLiteDatabase);
            Nosaukums.setText("");
            Vieta.setText("");
            Datums.setText("");
            Cena.setText("");
            Info.setText("");
            Info.clearFocus();
            Toast.makeText(getBaseContext(),"Dati Saglabati",Toast.LENGTH_LONG).show();
            userDBHelper.close();
        }

    }

    public void ietAtpakal(View view)
    {
        Intent intent = new Intent(Users.this,Main_Activity.class);
        startActivity(intent);

    }


}

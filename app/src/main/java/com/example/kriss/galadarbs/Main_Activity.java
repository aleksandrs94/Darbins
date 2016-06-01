package com.example.kriss.galadarbs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main_Activity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addContacts(View view)
    {

        Intent intent = new Intent(Main_Activity.this,Users.class);
        startActivity(intent);

    }

    public void viewContact(View view)
    {

        Intent intent = new Intent(Main_Activity.this,DataListActivity.class);
        startActivity(intent);

    }


}

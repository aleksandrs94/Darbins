package com.example.kriss.galadarbs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sludinajums extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sludinajums);
    }

    public void ietAtpakal(View view) {
        Intent intent = new Intent(context,DataListActivity.class);
        startActivity(intent);
    }
}

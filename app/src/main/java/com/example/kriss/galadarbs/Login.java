package com.example.kriss.galadarbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final Button bRegisterHere = (Button) findViewById(R.id.bRegisterHere);

    }

    public void akt_Register(View view)// poga iet uz aktivitāti Register
    {
        Intent otra = new Intent(this,Register.class);
        startActivity(otra);
    }


}




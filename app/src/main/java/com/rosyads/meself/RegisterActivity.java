package com.rosyads.meself;

/*
    Nama       : Rosyad Sulaiman
    NIM        : 10116349
    Kelas      : AKB - 08
    Pengerjaan : 15 Agustus


 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText inUser, inPass;
    Button btnRegister;

    public static final String mPreferences = "myPrefs";
    public static final String Name = "nameKey";
    public static final String Password = "passKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inUser = (EditText) findViewById(R.id.edUser);
        inPass = (EditText) findViewById(R.id.edPass);

        btnRegister = (Button)findViewById(R.id.btnSignUp);

        sharedPreferences = getSharedPreferences(mPreferences, Context.MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = inUser.getText().toString();
                String p = inPass.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name,n);
                editor.putString(Password,p);
                editor.apply();

                Toast.makeText(RegisterActivity.this,"Register Successful", Toast.LENGTH_SHORT).show();
                Intent s = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(s);
            }
        });

    }
}

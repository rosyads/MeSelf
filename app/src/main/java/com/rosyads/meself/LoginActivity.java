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

public class LoginActivity extends AppCompatActivity {
    EditText inUser, inPass;
    Button btnLogin, btnRegister;

    public static final String mPreferences = "myPrefs";
    public static final String Name = "nameKey";
    public static final String Password = "passKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inUser = (EditText) findViewById(R.id.edUser);
        inPass = (EditText) findViewById(R.id.edPass);

        btnLogin = (Button) findViewById(R.id.btnSignIn);
        btnRegister = (Button)findViewById(R.id.btnSignUp);

        sharedPreferences = getSharedPreferences(mPreferences, Context.MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = inUser.getText().toString();
                String p = inPass.getText().toString();

                String tempName = sharedPreferences.getString("nameKey","Name");
                String tempPass = sharedPreferences.getString("passKey","Password");

                if(n.equals(tempName)){
                    if(p.equals(tempPass)){
                        Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        Intent s = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(s);
                    }else{
                        Toast.makeText(LoginActivity.this,"Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Username Tidak Terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(s);
            }
        });

    }
}

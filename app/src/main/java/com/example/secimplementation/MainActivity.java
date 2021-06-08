package com.example.secimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        dbHelper db = new dbHelper(this);


        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name = ((EditText)findViewById(R.id.nentry)).getText().toString();
                String age = ((EditText)findViewById(R.id.age)).getText().toString();
                String email = ((EditText)findViewById(R.id.email)).getText().toString();
                String password = ((EditText)findViewById(R.id.password)).getText().toString();
                String gender= ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
                if(TextUtils.isEmpty(name))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(age))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Age", Toast.LENGTH_SHORT).show();

                }else if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();

                }else if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();

                }else if(TextUtils.isEmpty(gender))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Gender", Toast.LENGTH_SHORT).show();

                }
                else {
                    account account = new account(name);
                    account.getData(db,name,age,gender,email,password);
                    Intent i = new Intent(MainActivity.this, testscreen.class);
                    i.putExtra("account",account);
                    startActivity(i);
                }


            }
        });
    }
}
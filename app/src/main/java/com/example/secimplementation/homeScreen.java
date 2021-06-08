package com.example.secimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeScreen extends AppCompatActivity {
    private Button test;
    private Button games;
    private Button videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        test = (Button)findViewById(R.id.testbutton);
        games = (Button)findViewById((R.id.games));
        videos = (Button)findViewById((R.id.vidoes));
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = getIntent();
                account a = (account)i.getSerializableExtra("acc");
                i = new Intent(homeScreen.this,testscreen.class);
                i.putExtra("acc",a);
                startActivity(i);
            }
        });
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeScreen.this, games.class));
            }
        });
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeScreen.this, videos.class));
            }
        });


    }
}
package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final shop d=new shop(this);

        Button b = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);

        SharedPreferences myPrefs = this.getSharedPreferences("prefile", MODE_WORLD_READABLE);
        String username = myPrefs.getString("pref_name",null);
        String password = myPrefs.getString("pref_pass",null);
       if(username == null && password == null){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, login.class);
                    startActivity(in);

                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, signup.class);
                    startActivity(in);
                }
            });
        }
       else
       {
           Intent i=new Intent(MainActivity.this,login.class);
           startActivity(i);

       }}
}

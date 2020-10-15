package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    public static final String preferencename="prefile";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final CheckBox cc=(CheckBox)findViewById(R.id.checkBox);
        final SharedPreferences shared;
        shared=getSharedPreferences(preferencename,MODE_PRIVATE);

        Button b4=(Button)findViewById(R.id.log);
        Button b6=(Button)findViewById(R.id.button6);

        final EditText e=(EditText)findViewById(R.id.editText);
        final EditText e2=(EditText)findViewById(R.id.editText2);
        final TextView forgetpass=(TextView)findViewById(R.id.textView2);
        final shop d=new shop(this);


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(login.this,signup.class);
                startActivity(in);
            }

        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String uname=e.getText().toString();
            String pass=e2.getText().toString();
                boolean check=d.emailpass(uname,pass);
    if(check==true) {
        if(cc.isChecked())
        {
            boolean boolcheck=cc.isChecked();
            SharedPreferences.Editor editor=shared.edit();
            editor.putString("pref_name",uname);
            editor.putString("pref_pass",pass);
            editor.putBoolean("pref_check",boolcheck);
            editor.apply();
            Toast.makeText(getApplicationContext(),"setting have been saved",Toast.LENGTH_LONG).show();
        }
        else
        {
            shared.edit().clear().apply();
        }

        Toast.makeText(getApplicationContext(), " Succesfully login :) ", Toast.LENGTH_LONG).show();


        Intent inn = new Intent(login.this,cart.class);

        final int g= d.getcustid(uname);

        //inn.putExtra("name",uname);
        inn.putExtra("n",g);

        startActivity(inn);



        e.getText().clear();
        e2.getText().clear();
    }

    else
        Toast.makeText(getApplicationContext(), " Wrong name or password !!:(", Toast.LENGTH_LONG).show();


            }
        });

        //SharedPreferences shared22=getSharedPreferences(preferencename,MODE_PRIVATE);
        if(shared.contains("pref_name"))
        {
            String q=shared.getString("pref_name","not found");
            e.setText(q.toString());
        }
        if(shared.contains("pref_pass"))
        {    String q2=shared.getString("pref_pass","not found");
            e2.setText(q2.toString());
        }
        if(shared.contains("pref_check")) {
            boolean q3 = shared.getBoolean("pref_check", false);
            cc.setChecked(q3);
        }

    forgetpass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent pass=new Intent(login.this,Password.class);
            startActivity(pass);
        }
    });
    }
}

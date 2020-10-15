package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        final shop ss=new shop(this);


        final Button bmatch=(Button)findViewById(R.id.Match);

        final Button bconfirm=(Button)findViewById(R.id.Confirm);
        final  EditText eusername=(EditText)findViewById(R.id.usernamee);

        final EditText ecolor=(EditText)findViewById(R.id.checkcolor);

        final EditText epass=(EditText)findViewById(R.id.newpass);


        epass.setVisibility(View.GONE);
        bconfirm.setVisibility(View.GONE);




        bmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final  String scolor=ecolor.getText().toString();

                final String susername=eusername.getText().toString();

                final boolean checkk=ss.question(susername,scolor);

                if(checkk==true)
                {
                    Toast.makeText(getApplicationContext(),"They are matched",Toast.LENGTH_LONG).show();

                    epass.setVisibility(View.VISIBLE);
                    bconfirm.setVisibility(View.VISIBLE);
                    //



                }
            }

        });


        bconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String susername=eusername.getText().toString();

                final  String scolor=ecolor.getText().toString();
                final String spass=epass.getText().toString();
                ss.updatepass(susername,scolor,spass);

                Toast.makeText(getApplicationContext(),"Password is changed :D",Toast.LENGTH_LONG).show();
                Intent loo=new Intent(Password.this,login.class);
                startActivity(loo);




            }
        });


    }
}

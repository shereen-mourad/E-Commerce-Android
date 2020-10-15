package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button b4 = (Button) findViewById(R.id.reg);
        Button b5=(Button)findViewById(R.id.login);

      final  TextView e=(TextView)findViewById(R.id.textView6);

       final  EditText e1=(EditText)findViewById(R.id.fname);

       final EditText e2=(EditText)findViewById(R.id.g);

        final EditText e3=(EditText)findViewById(R.id.j);

        final EditText e4=(EditText)findViewById(R.id.userEmail);

        final EditText e5=(EditText)findViewById(R.id.userpassword);

       final  EditText e6=(EditText)findViewById(R.id.reuserpassword);
       final EditText e11=(EditText)findViewById(R.id.color);

        final Button b3 = (Button) findViewById(R.id.view);

        final shop d=new shop(this);

        String date = getIntent().getStringExtra("date");
        if(date!=null)
            e.setText(date);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(signup.this,Calenderr.class);
                startActivity(in);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final   String ee5= e5.getText().toString();
                final String ee6= e6.getText().toString();

                final   String ee4= e4.getText().toString();
                final String ee3= e3.getText().toString();

                final   String ee2= e2.getText().toString();
                final String ee1= e1.getText().toString();
                final String ee11= e11.getText().toString();


if(ee5.equals("")||ee6.equals("")||ee4.equals("")||ee3.equals("")||ee2.equals("")||ee1.equals("")||ee11.equals(""))
    Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_LONG).show();
else{
                    if (ee6.equals(ee5)) {
                        boolean ins = d.addcust(e1.getText().toString(), e4.getText().toString(), e2.getText().toString(), e.getText().toString(), e3.getText().toString(), e5.getText().toString(),e11.getText().toString());
                        if (ins == true)

                            Toast.makeText(getApplicationContext(), "succesfully registerd ", Toast.LENGTH_LONG).show();
                       int g= d.getcustid(ee4);
                        Intent i=new Intent(signup.this,cart.class);
                      //  i.putExtra("name",ee4);
                        i.putExtra("n",g);
                        startActivity(i);
                    } else
                        Toast.makeText(getApplicationContext(), "Not match", Toast.LENGTH_LONG).show();
                }

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(signup.this,login.class);
                startActivity(ii);
            }
        });

    }
}

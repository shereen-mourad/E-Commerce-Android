package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends AppCompatActivity {
public EditText pricce;
    public EditText date;
    public EditText address;
    public List<Integer>listprice=new ArrayList<Integer>();

    public List<Integer>listid=new ArrayList<Integer>();

    public List<Integer>listquantity=new ArrayList<Integer>();
    shop s=new shop(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        final int cid=getIntent().getExtras().getInt("custid");
        pricce=(EditText)findViewById(R.id.TotalPrice);
        Button bsub=(Button)findViewById(R.id.submit);

        Button bshow=(Button)findViewById(R.id.show);
        date=(EditText)findViewById(R.id.Date);

        address=(EditText)findViewById(R.id.address);

        Cursor pp= s.getPrice(cid);
        while (!pp.isAfterLast()) {
            listprice.add(pp.getInt(0));
            pp.moveToNext();
        }

        bshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum=0;
                for(int i = 0; i < listprice.size(); i++)
                {
                    sum += listprice.get(i);

                    pricce.setText(String.valueOf(sum));
                }
            }
        });

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        date.setText(currentDateTimeString);
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sdate=date.getText().toString();
                String sadd=address.getText().toString();
                long orid= s.addinorders(sdate,cid,sadd);

               /* Cursor c=  s.getproandquantity(cid);
                while (!c.isAfterLast()) {
                    listid.add(c.getInt(5));
                    c.moveToNext();
                }
                int proid= c.getInt(5);
              int quantity=c.getInt(3);*/

               s.addinordersdetails(orid,cid);

                   s.deletecart(cid);
                Intent is=new Intent(Order.this,bye.class);
                startActivity(is);

            }
        });

    }
}

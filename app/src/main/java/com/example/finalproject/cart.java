package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class cart extends AppCompatActivity {
    public final shop s=new shop(this);
    public ListView l1;
    public ArrayAdapter<String>arr;
    public  Cursor coo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Button bb=(Button)findViewById(R.id.button13);
     final  String g= getIntent().getExtras().getString("name");

        final  int gg= getIntent().getExtras().getInt("n");


        //Button bback=(Button)findViewById(R.id.babkk);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1 = (ListView) findViewById(R.id.ll);
                arr = new ArrayAdapter<String>(getApplicationContext(), R.layout.row);
                l1.setAdapter(arr);

                Cursor cc = s.showp();
                while (!cc.isAfterLast()) {
                    arr.add(cc.getString(0) + "  " + "priceIs: " + cc.getString(1));
                    cc.moveToNext();
                }
                l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Cursor sss = s.getproid();
                        Intent li1 = new Intent(cart.this, addtocart.class);

                        sss.moveToPosition(position);
                        li1.putExtra("proid", sss.getInt(0));

                        li1.putExtra("name1",g);

                        li1.putExtra("name2",gg);


                        //Toast.makeText(getApplicationContext(), "dddd", Toast.LENGTH_LONG).show();

                        startActivity(li1);


                    }
                });


               final ListView l2 = (ListView) findViewById(R.id.ll2);
                ArrayAdapter<String> arr2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.row);
                l2.setAdapter(arr2);
                Cursor cc2 = s.showp2();
                while (!cc2.isAfterLast()) {
                    arr2.add(cc2.getString(0) + "  " + "priceIs: " + cc2.getString(1));
                    cc2.moveToNext();
                }
                l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Cursor ssss = s.getproid2();
                        Intent li1 = new Intent(cart.this, addtocart.class);

                        ssss.moveToPosition(position);
                        li1.putExtra("proid", ssss.getInt(0));
                        li1.putExtra("name1",g);

                        li1.putExtra("name2",gg);

                      //  Toast.makeText(getApplicationContext(), "bbb", Toast.LENGTH_LONG).show();

                        startActivity(li1);


                    }
                });

                ListView l3 = (ListView) findViewById(R.id.ll3);
                ArrayAdapter<String> arr3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.row);
                l3.setAdapter(arr3);
                Cursor cc3 = s.showp3();
                while (!cc3.isAfterLast()) {
                    arr3.add(cc3.getString(0) + "  " + "priceIs: " + cc3.getString(1));
                    cc3.moveToNext();
                }
               l3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Cursor sss = s.getproid3();
                        Intent li1 = new Intent(cart.this, addtocart.class);

                        sss.moveToPosition(position);
                        li1.putExtra("proid", sss.getInt(0));

                        li1.putExtra("name1",g);

                        li1.putExtra("name2",gg);

                       // Toast.makeText(getApplicationContext(), "dddd", Toast.LENGTH_LONG).show();

                        startActivity(li1);


                    }
                });


                ListView l4 = (ListView) findViewById(R.id.ll4);
                ArrayAdapter<String> arr4 = new ArrayAdapter<String>(getApplicationContext(), R.layout.row);
                l4.setAdapter(arr4);
                Cursor cc4 = s.showp4();
                while (!cc4.isAfterLast()) {
                    arr4.add(cc4.getString(0) + "  " + "priceIs: " + cc4.getString(1));
                    cc4.moveToNext();
                }


                l4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Cursor sss = s.getproid4();
                        Intent li1 = new Intent(cart.this, addtocart.class);

                        sss.moveToPosition(position);
                        li1.putExtra("proid", sss.getInt(0));

                        li1.putExtra("name1",g);

                        li1.putExtra("name2",gg);


                        // Toast.makeText(getApplicationContext(), "dddd", Toast.LENGTH_LONG).show();

                        startActivity(li1);


                    }
                });

            }



        });

        }

    }


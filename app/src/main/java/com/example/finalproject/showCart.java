package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class showCart extends AppCompatActivity {

    public ListView l;
    public List<String>list=new ArrayList<String>();

    public List<Integer>listprice=new ArrayList<Integer>();
    public List<Integer>listprice2=new ArrayList<Integer>();

    public ArrayAdapter<String>arr;
    public TextView pricce;
    public shop s=new shop(this);
    public  String g;
    public  int quan;
    public  int prid;
    public   int cid;
    public String sproname;
    public  Cursor cc;
    public  Cursor cc2;
    //int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);

        g=getIntent().getExtras().getString("proname");
        cid=getIntent().getExtras().getInt("custid");
        quan=getIntent().getExtras().getInt("quant");
        prid=getIntent().getExtras().getInt("prid");


        l=(ListView)findViewById(R.id.lp);

        cc = s.showincart(cid);
        while (!cc.isAfterLast()) {
            list.add(cc.getString(0));
            cc.moveToNext();
        }

        arr = new ArrayAdapter<String>(getApplicationContext(), R.layout.row,list);
        l.setAdapter(arr);

        registerForContextMenu(l);
       /*  pricce=(TextView)findViewById(R.id.pricce);
        Cursor pp= s.getPrice(cid);
        while (!pp.isAfterLast()) {
            listprice.add(pp.getInt(0));
            pp.moveToNext();
        }
        for(int i = 0; i < listprice.size(); i++)
        {
            sum += listprice.get(i);

        }

        pricce.setText(String.valueOf(sum));*/
        Button order=(Button)findViewById(R.id.Order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt=new Intent(showCart.this,Order.class);
                intt.putExtra("custid",cid);
                startActivity(intt);

            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = ( AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        TextView pronameView=(TextView) info.targetView;
        //listid.get(info.position);



        String proname = pronameView.getText().toString();

        switch (item.getItemId())
        {

            case (R.id.Edit):{

                Intent in=new Intent(this,updateQuantity.class);
              /* String ppp= pricce.getText().toString();
               in.putExtra("price",ppp);
               in.put*/
                in.putExtra("prname",proname);
                Cursor get= s.getquantityfromname(proname,cid);
                int getquant= get.getInt(0);
                in.putExtra("cid",cid);
                in.putExtra("quan",getquant);
                startActivity(in);

                return true;
            }

            case (R.id.Delete):{

                list.remove(info.position);
                arr.notifyDataSetChanged();
                s.del(proname,cid);
              /*  int sum2=0;
                Cursor pp2= s.getPrice(cid);
                while (!pp2.isAfterLast()) {
                    listprice2.add(pp2.getInt(0));
                    pp2.moveToNext();
                }
                for(int i = 0; i < listprice2.size(); i++)
                {
                    sum2 += listprice2.get(i);

                }

                pricce.setText(String.valueOf(sum2));*/
                return true;
            }


        }
        return false;
    }

    @Override
    protected void onRestart() {
        arr.clear();
        Cursor c=s.fitchallproduct();
        while (!c.isAfterLast()){
            arr.add(c.getString(0));
            c.moveToNext();}

        super.onRestart();
    }
}

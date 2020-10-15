package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class updateQuantity extends AppCompatActivity {

    public List<Integer> listprice3=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quantity);
        final shop s=new shop(this);
        final TextView t=(TextView)findViewById(R.id.oldquan);

        final EditText ttt=(EditText)findViewById(R.id.quan);
        Button b=(Button)findViewById(R.id.con);


        final  int res3=getIntent().getExtras().getInt("quan");
        t.setText(String.valueOf(res3));

//        final int res=Integer.parseInt(tt);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tt=ttt.getText().toString();
                s.update(getIntent().getExtras().getString("prname"),getIntent().getExtras().getInt("cid"),res3,tt);
            /*  int cid=  getIntent().getExtras().getInt("cid");
                int sum3=0;
                Cursor pp2= s.getPrice(cid);
                while (!pp2.isAfterLast()) {
                    listprice3.add(pp2.getInt(0));
                    pp2.moveToNext();
                }
                for(int i = 0; i < listprice3.size(); i++)
                {
                    sum3 += listprice3.get(i);

                }
               String sprice= getIntent().getExtras().getString("price");
               sprice.replace(String.valueOf(sum3));*/

                Toast.makeText(getApplicationContext(),"updated,",Toast.LENGTH_LONG).show();
                t.setText(String.valueOf(res3));

            }
        });
    }
}

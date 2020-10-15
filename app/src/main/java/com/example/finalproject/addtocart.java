package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class addtocart extends AppCompatActivity {
private int num=1;

 public shop d = new shop(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart);
        final int proid = getIntent().getExtras().getInt("proid");
     //  final String f=getIntent().getExtras().getString("name1");

        final int f1=getIntent().getExtras().getInt("name2");

        final Cursor cc = d.getproductdetails(proid);


        ((TextView) findViewById(R.id.t)).setText("Name:" + cc.getString(1));

        ((TextView) findViewById(R.id.tt)).setText("Price :" + cc.getString(2));

        ((TextView) findViewById(R.id.ttt)).setText("Total Quantity :" + cc.getString(3));

        ((TextView) findViewById(R.id.tttt)).setText("CustID:"+ f1 );



        final   TextView q=(TextView)findViewById(R.id.qu);

        ImageView im2=(ImageView)findViewById(R.id.imageView2);

       // ImageView im1=(ImageView)findViewById(R.id.imageView);
        Button im1=(Button)findViewById(R.id.image) ;

        ImageView im3=(ImageView)findViewById(R.id.imageView3);
       String a= cc.getString(3);
       final int res=Integer.parseInt(a);
        String a2= cc.getString(2);
        final int res2=Integer.parseInt(a2);


        q.setText(String.valueOf(num));
    im3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(num<res)
            {

                num++;
                q.setText(String.valueOf(num));

            }
        }
    });

    im2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          //  Toast.makeText(getApplicationContext(),num , Toast.LENGTH_LONG).show();
         if(num>1)
            {

                num--;

                q.setText(String.valueOf(num));
            }
        }
    });

im1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String a3=q.getText().toString();
        final int res3=Integer.parseInt(a3);

           d.addprod( ((TextView) findViewById(R.id.t)).getText().toString(),res2,res3,f1,proid);
       // if( res3>rr) {
           Intent nn = new Intent(addtocart.this, showCart.class);
           nn.putExtra("prid",proid);
           nn.putExtra("proname", ((TextView) findViewById(R.id.t)).getText().toString());
           nn.putExtra("custid", f1);
           nn.putExtra("quant",res3);

           startActivity(nn);
       }
     /*  else

           Toast.makeText(getApplicationContext(),"Product isnot available",Toast.LENGTH_LONG).show();
    }*/
});



    }
}

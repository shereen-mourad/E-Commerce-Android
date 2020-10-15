package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class shop extends SQLiteOpenHelper {
    private static String databasename = "md";
    SQLiteDatabase d;

    public shop(@Nullable Context context) {
        super(context, databasename, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table Customers(custid integer primary key autoincrement,custname text,username text,gender text,birth text,job text,password text,ques text);");
        db.execSQL("create table Orders(ordid integer primary key autoincrement,ordate text,custid integer ,address text,foreign key (custid) references Customers(custid));");
        db.execSQL("create table Categories(catid integer primary key autoincrement,catname text);");
        db.execSQL("create table Products(proid integer primary key autoincrement,proname text,price integer,quantity integer,catid integer,foreign key (catid) references Categories(catid));");
        db.execSQL("create table OrderDetails(ordid integer not null ,proid integer not null,quantity integer,foreign key (ordid) references Orders(ordid),foreign key (proid) references Products(proid),primary key(ordid,proid) );");
        db.execSQL("create table Carts(cartid integer primary key autoincrement,proname text,price integer,quantity integer,custid integer,proid integer,foreign key (custid) references Customers(custid),foreign key (proid) references Products(proid));");
        ContentValues dd = new ContentValues();
        dd.put("catname", "Perfumes");

        db.insert("Categories", null, dd);

        dd.put("catname", "Body Splashes");

        db.insert("Categories", null, dd);

        dd.put("catname", "Body lotions");

        db.insert("Categories", null, dd);

        dd.put("catname", "Deodorants");

        db.insert("Categories", null, dd);


        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Sauvage',2300,20,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Si',1200,20,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Lacoste',1800,20,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Black Opium',2250,20,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Invictus',1000,15,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Dolce And Gabbana',5500,15,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Versace For Men ',1500,15,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Versace For Women',900,15,1)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Pure Seduction ',250,10,2)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Vanilla Lace ',250,10,2)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Dark Kiss',300,10,2)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Into the Night',300,10,2)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Warm Vanilla',350,10,3)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Mad About You',350,10,3)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Love Spell',200,10,3)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Sheer',200,10,3)");


        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Axe',50,25,4)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Fa',35,25,4)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Dove',80,25,4)");

        db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Nivea ',45,25,4)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Customers ");
        db.execSQL("drop table if exists Orders ");
        db.execSQL("drop table if exists Categories ");
        db.execSQL("drop table if exists Products ");
        db.execSQL("drop table if exists OrderDetails ");

        db.execSQL("drop table if exists Carts ");
        onCreate(db);
    }

    public boolean addcust(String name, String uname, String gen, String bi, String job, String pass, String que) {

        d = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("custname", name);
        row.put("username", uname);
        row.put("gender", gen);
        row.put("birth", bi);
        row.put("job", job);
        row.put("password", pass);

        row.put("ques", que);

        long ins = d.insert("Customers", null, row);
        d.close();
        if (ins == -1) return false;
        else
            return true;


    }

    public boolean emailpass(String em, String pass) {

        d = getReadableDatabase();
        Cursor cursor = d.rawQuery("select username,password from Customers where username=? and password=?", new String[]{em, pass});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean question(String us, String q) {
        d = getReadableDatabase();
        Cursor cursor = d.rawQuery("select username,ques from Customers where username=? and ques=?", new String[]{us, q});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public void updatepass(String us, String q, String pass) {
        d = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("password", pass);

        d.update("Customers", row, "username =? and ques=? ", new String[]{us, q});

    }

    public Cursor showp() {

        d = getReadableDatabase();
        String[] ro = {"proname", "price", "quantity", "catid", "proid"};
        Cursor c = d.query("Products", ro, "catid=1 and price ", null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        d.close();
        return c;

    }

    public Cursor showp2() {

        d = getReadableDatabase();
        String[] ro = {"proname", "price", "quantity", "catid", "proid"};
        Cursor c = d.query("Products", ro, "catid=2 and price", null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        d.close();
        return c;

    }

    public Cursor showp3() {

        d = getReadableDatabase();
        String[] ro = {"proname", "price", "quantity", "catid", "proid"};
        Cursor c = d.query("Products", ro, "catid=3 and price", null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        d.close();
        return c;

    }

    public Cursor showp4() {

        d = getReadableDatabase();
        String[] ro = {"proname", "price", "quantity", "catid", "proid"};
        Cursor c = d.query("Products", ro, "catid=4 and price", null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        d.close();
        return c;

    }

    public Cursor getproid() {
        d = getReadableDatabase();
        String[] ro = {"proid", "proname", "price", "quantity", "catid"};
        Cursor cur = d.query("Products", ro, "catid=1 and proid", null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;

    }

    public Cursor getproid2() {
        d = getReadableDatabase();
        String[] ro = {"proid", "proname", "price", "quantity", "catid"};
        Cursor cur = d.query("Products", ro, "catid=2 and proid", null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;

    }

    public Cursor getproid3() {
        d = getReadableDatabase();
        String[] ro = {"proid", "proname", "price", "quantity", "catid"};
        Cursor cur = d.query("Products", ro, "catid=3 and proid", null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;

    }

    public Cursor getproid4() {
        d = getReadableDatabase();
        String[] ro = {"proid", "proname", "price", "quantity", "catid"};
        Cursor cur = d.query("Products", ro, "catid=4 and proid", null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;

    }

    public Cursor getproductdetails(int id) {
        d = getReadableDatabase();
        String[] ro = {"proid", "proname", "price", "quantity", "catid"};
        Cursor cur = d.query("Products", ro, "proid=" + id, null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;

    }

    public void addprod(String name, int price, int quant, int nam, int proid) {

        d = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("proname", name);
        row.put("price", price);
        row.put("quantity", quant);
        row.put("custid", nam);
        row.put("proid", proid);

        long ins = d.insert("Carts", null, row);
        d.close();


    }

    public int getcustid(String una) {
        d = getReadableDatabase();
        //String[] ro = {"custid","custname" ,"username","gender ","birth ","job","password","ques"};
        //  Cursor cur = d.query("Customers", ro, "custid =? and username=una", null, null, null, null);
        Cursor cur = d.rawQuery("select custid,username from Customers where username=? ", new String[]{una});
        cur.moveToFirst();

        d.close();
        return cur.getInt(0);
    }


    public Cursor showincart(int id) {

        d = getReadableDatabase();
        String[] ro = {"proname", "proid", "quantity", "custid", "price"};

        Cursor c = d.rawQuery("select proname,quantity  from Carts where custid=" + id, null);
        if (c != null) {
            c.moveToFirst();
        }
        d.close();
        return c;

    }

    /*public Cursor checkquant(int pro) {

        d = getReadableDatabase();
        String[] ro = { "quantity"};
        Cursor c = d.rawQuery("select quantity from Carts where proid="+pro,null);
        if (c != null) {
            c.moveToFirst();
        }
        d.close();
        return c;

    }*/
    public void del(String pro, int cid) {
        d = getWritableDatabase();
        d.delete("Carts", "proname='" + pro + "'" + "and custid=" + cid, null);
        d.close();


    }

    public void update(String pro, int cid, int OQ, String NQ) {

        d = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("quantity", NQ);
        String s = String.valueOf(OQ);

        String ccid = String.valueOf(cid);
        d.update("Carts", row, "proname =? and quantity=? and custid=? ", new String[]{pro, s, ccid});

        d.close();


    }

    /* public Cursor quant(int pro){
         d = getReadableDatabase();
         Cursor cur = d.rawQuery("select * from Carts where proid= "+pro, null);
         cur.moveToFirst();
         d.close();
         return cur;
     }*/
    public Cursor fitchallproduct() {

        d = getReadableDatabase();

        String[] ro = {"cartid", "proname", "price", "quantity", "custid", "proid"};
        Cursor cur = d.query("Carts", ro, null, null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;
    }

    public Cursor getquantityfromname(String name, int Cid) {
        d = getReadableDatabase();
        String[] ro = {"quantity"};
        Cursor cur = d.query("Carts", ro, "  proname='" + name + "'" + "and custid=" + Cid, null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;

    }

    public Cursor getPrice(int Cid) {
        d = getReadableDatabase();
        String[] ro = {"price"};
        Cursor cur = d.query("Carts", ro, " custid=" + Cid, null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;

    }

    public long addinorders(String date, int custid, String address) {

        d = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("ordate", date);
        row.put("custid", custid);
        row.put("address", address);

        long id = d.insert("Orders", null, row);
        return id;
    }


    public void addinordersdetails(long ori, int id) {

        d = getWritableDatabase();
        ContentValues row = new ContentValues();
        //String[] ro = {"proid", "quantity", "price"};
      //  Cursor cur = d.rawQuery("select proid,quantity ,price from Carts where custid=" + id, null);
        String[] ro = {"proid", "quantity"};
        Cursor cur = d.query("Carts", ro, " custid=" + id, null, null, null, null);
cur.moveToFirst();
       // row.put("ordid", ori);

        while (!cur.isAfterLast()) {
            d.execSQL("insert into OrderDetails (ordid,proid,quantity)" + "values("+ori+","+cur.getInt(0)+","+cur.getInt(1)+")");

            //db.execSQL("insert into Products (proname,price,quantity,catid)" + "values('Nivea ',45,25,4)");

          /*  row.put("proid", cur.getInt(0));

            row.put("quantity", cur.getInt(1));

            row.put("price", cur.getInt(2));

            d.insert("OrderDetails", null, row);*/

            cur.moveToNext();
        }
        d.close();
    }


    public Cursor getproandquantity(int cid){

        d = getReadableDatabase();

        String[] ro = {"cartid","proname", "price", "quantity", "custid", "proid"};
        Cursor cur = d.query("Carts", ro, null, null, null, null, null);

        cur.moveToFirst();

        d.close();
        return cur;
    }
    public void deletecart(int cid)
    {
        d = getWritableDatabase();
        d.delete("Carts", "custid=" + cid, null);
        d.close();


    }

}
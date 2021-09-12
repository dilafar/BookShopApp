package com.example.appbookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.Nullable;

import com.example.appbookshop.Model.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders"+
                        "(id integer primary key autoincrement,"+
                        "productname text,"+
                         "image int," +
                          "price int,"+
                           "qty int,"+
                            "offer int)"
        );




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP table if exists orders");
            onCreate(sqLiteDatabase);

    }

    public boolean insertOrder(String productname,int image,int price,int qty,int offer){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("productname",productname);
        values.put("image",image);
        values.put("price",price);
        values.put("qty",qty);
        values.put("offer",offer);
        long id = database.insert("orders",null,values);
        if(id<=0){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<OrdersModel>getOrders(){
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders",null);
        if(cursor.moveToNext()){
            while(cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrdernumber(cursor.getInt(0)+"");
                model.setOrdername(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                model.setQty(cursor.getInt(4)+"");
                model.setOffer(cursor.getInt(5)+"");
                orders.add(model);





            }
        }
        cursor.close();
        database.close();
        return orders;
    }

    public Cursor getOrderById(int id){


        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = "+id,null);
        if(cursor != null){


                cursor.moveToFirst();







        }


        return cursor;

    }

    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }




    public boolean UpdateOrder(String productname,int image,int price,int qty,int offer,int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("productname",productname);
        values.put("image",image);
        values.put("price",price);
        values.put("qty",qty);
        values.put("offer",offer);
        long row = database.update("orders",values,"id="+id,null);
        if(row<=0){
            return false;
        }else{
            return true;
        }
    }


}

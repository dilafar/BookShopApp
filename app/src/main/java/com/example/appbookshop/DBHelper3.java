package com.example.appbookshop;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appbookshop.Model.MainModel;

import java.util.ArrayList;

public class DBHelper3 extends SQLiteOpenHelper {
    final static String DBNAME = "mydatabase5.db";
    final static int DBVERSION = 2;

    public DBHelper3(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table items"+
                        "(id integer primary key autoincrement,"+
                        "image int,"+
                        "category text,"+
                        "productname text,"+
                        "discription text,"+
                        "avqty int,"+
                        "price int,"+
                        "offer int)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP table if exists items");
            onCreate(sqLiteDatabase);
    }

    public boolean insertitem(int image,String category,String productname,String description,int qty,int price,int offer){

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("image",image);
        values.put("category",category);
        values.put("productname",productname);
        values.put("discription",description);
        values.put("avqty",qty);
        values.put("price",price);
        values.put("offer",offer);
        long id = database.insert("items",null,values);

        if(id<=0){
            return false;
        }else{
            return true;
        }


    }


    public ArrayList<MainModel> getItems(){
        ArrayList<MainModel> mainModels = new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from items",null );
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                MainModel model = new MainModel();
                model.setItemID(cursor.getInt(0)+"");
                model.setPimage(cursor.getInt(1));
                model.setCategory(cursor.getString(2));
                model.setPname(cursor.getString(3));
                model.setPdiscription(cursor.getString(4));
                model.setPavqty(cursor.getInt(5)+"");
                model.setPrice(cursor.getInt(6)+"");
                model.setOffer(cursor.getInt(7)+"");
                mainModels.add(model);
            }
        }
        cursor.close();
        database.close();
        return mainModels;
    }

    public ArrayList<MainModel> getItemsbycategory(String category){
        ArrayList<MainModel> mainModels = new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from items where category="+category,null );
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                MainModel model = new MainModel();
                model.setItemID(cursor.getInt(0)+"");
                model.setPimage(cursor.getInt(1));
                model.setCategory(cursor.getString(2));
                model.setPname(cursor.getString(3));
                model.setPdiscription(cursor.getString(4));
                model.setPavqty(cursor.getInt(5)+"");
                model.setPrice(cursor.getInt(6)+"");
                model.setOffer(cursor.getInt(7)+"");
                mainModels.add(model);
            }
        }
        cursor.close();
        database.close();
        return mainModels;
    }



    public Cursor getitemyById(int id){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from items where id="+id,null);
        if(cursor !=null){
            cursor.moveToFirst();

        }
        return cursor;
    }


    public boolean updateitem(int image,String category,String productname,String discription,int qty,int price,int offer,int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("image",image);
        values.put("category",category);
        values.put("productname",productname);
        values.put("discription",discription);
        values.put("avqty",qty);
        values.put("price",price);
        values.put("offer",offer);
        long row = database.update("items",values,"id="+id,null);
        if(row<=0){
            return false;
        }else {
            return true;
        }
    }





    public int deleteItem(String id){
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete("items","id="+id,null);
    }

}

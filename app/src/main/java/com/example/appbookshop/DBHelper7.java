package com.example.appbookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appbookshop.Model.DeliveryModel;
import com.example.appbookshop.Model.OrdersModel;

import java.util.ArrayList;

public class DBHelper7 extends SQLiteOpenHelper {

    final static String DBNAME = "delivery2.db";
    final static int DBVERSION = 2;


    public DBHelper7(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table delivery"+
                        "(id integer primary key autoincrement,"+
                        "name text,"+
                        "total text,"+
                        "status text,"+
                        "phone text,"+
                        "address text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists delivery");
        onCreate(sqLiteDatabase);
    }


    public boolean insertdelivery(String name,String total,String status,String phone,String address){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("total",total);
        values.put("status",status);
        values.put("phone",phone);
        values.put("address",address);
        long id = database.insert("delivery",null,values);
        if(id<=0){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<DeliveryModel> getdeliveries(){
        ArrayList<DeliveryModel> models = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from delivery",null);
        if(cursor.moveToNext()){
            while(cursor.moveToNext()){
                DeliveryModel model = new DeliveryModel();
                model.setDeliveryID(cursor.getInt(0)+"");
                model.setName(cursor.getString(1));
                model.setTotalpay(cursor.getString(2));
                model.setStatus(cursor.getString(3));
                model.setPhone(cursor.getString(4));
                model.setAddress(cursor.getString(5));
                models.add(model);





            }
        }
        cursor.close();
        database.close();
        return models;
    }

    public int deletedelivery(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("delivery","id="+id,null);
    }

    public boolean Updatedeliverystatus(String status,int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("status",status);


        long row = database.update("delivery",values,"id="+id,null);
        if(row<=0){
            return false;
        }else{
            return true;
        }

    }





}

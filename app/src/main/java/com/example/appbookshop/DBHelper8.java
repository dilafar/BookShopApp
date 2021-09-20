package com.example.appbookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appbookshop.Model.DeliveryModel;
import com.example.appbookshop.Model.PaymentModel;

import java.util.ArrayList;

public class DBHelper8  extends SQLiteOpenHelper {

    final static String DBNAME = "payment2.db";
    final static int DBVERSION = 2;

    public DBHelper8(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table payment"+
                        "(id integer primary key autoincrement,"+
                        "cardname text,"+
                        "cardnumber text,"+
                        "expirydate text,"+
                        "ccv text,"+
                        "uname text,"+
                        "totalpay text,"+
                        "paymentdate text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists payment");
        onCreate(sqLiteDatabase);
    }

    public boolean insertpayment(String cname,String cnumber,String edate,String ccv,String uname,String tpay,String pdate){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("cardname",cname);
        values.put("cardnumber",cnumber);
        values.put("expirydate",edate);
        values.put("ccv",ccv);
        values.put("uname",uname);
        values.put("totalpay",tpay);
        values.put("paymentdate",pdate);
        long id = database.insert("payment",null,values);
        if(id<=0){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<PaymentModel> getpaymenthistory(){
        ArrayList<PaymentModel> models = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from payment",null);
        if(cursor.moveToNext()){
            while(cursor.moveToNext()){
                PaymentModel model = new PaymentModel();
                model.setPaymentID(cursor.getInt(0)+"");
                model.setCardname(cursor.getString(1));
                model.setCardnumber(cursor.getString(2));
                model.setExpirydate(cursor.getString(3));
                model.setCcv(cursor.getString(4));
                model.setUname(cursor.getString(5));
                model.setTotalpay(cursor.getString(6));
                model.setPaymentdate(cursor.getString(7));
                models.add(model);





            }
        }
        cursor.close();
        database.close();
        return models;
    }

}

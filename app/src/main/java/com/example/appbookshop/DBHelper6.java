package com.example.appbookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper6 extends SQLiteOpenHelper {
    public static final String DBNAME = "register.db";
    public static final int DBVERSION = 2;
    public static final String TABLE_NAME = "user";
    public static final String COL_1 ="id";
    public static final String COL_2 = "username";
    public static final String COL_3 = "email";
    public static final String COL_4 = "contactnumber";
    public static final String COL_5 = "password";

    public DBHelper6(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user"+"(id integer primary key autoincrement,"+
                "username text,"+
                "email text,"+
                "contactnumber text,"+
                "password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP table if exists user");
            onCreate(sqLiteDatabase);
    }

    public long adduser(String username,String email,String cnumber, String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("contactnumber",cnumber);
        contentValues.put("password",password);
        long res = database.insert("user",null,contentValues);
        database.close();
        return res;
    }

    public boolean checkuser(String username,String password){
        String[] columns = {COL_1};
        SQLiteDatabase db =  getReadableDatabase();
        String selection = COL_2 + " =? " + " and " + COL_5 + " =? ";
        String[] selectionArgs ={username,password};
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count  = cursor.getCount();
        cursor.close();
        db.close();
        if(count>0){
            return true;

        }else {
            return false;

        }
    }

    public Cursor getData(String username){
        SQLiteDatabase db = getReadableDatabase();
        String sql="select * from " + TABLE_NAME + " where username =?";
        String[] select={username};
        Cursor cursor=db.rawQuery(sql,select);
        if (cursor != null)
        {   cursor.moveToFirst();}
        return cursor;
    }

    public boolean Updateuser(String name,String email,String phone,String password,int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",name);
        values.put("email",email);
        values.put("contactnumber",phone);
        values.put("password",password);

        long row = database.update("user",values,"id="+id,null);
        if(row<=0){
            return false;
        }else{
            return true;
        }

    }

    public int deleteuser(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("user","id="+id,null);
    }

}

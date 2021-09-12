package com.example.appbookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appbookshop.Model.CategoryModel;

import java.util.ArrayList;

public class DBHelper4 extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase2.db";
    final static int DBVERSION =2;

    public DBHelper4(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table category"+  "(id integer primary key autoincrement,"+
                        "categoryname text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP table if exists category");
            onCreate(sqLiteDatabase);
    }

    public boolean insertCategory(String category){
        SQLiteDatabase database2 = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("categoryname",category);
        long id = database2.insert("category",null,values);
        if(id<=0){
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<CategoryModel> getcategory(){
        ArrayList<CategoryModel> categoryModels=new ArrayList<>();
        SQLiteDatabase database2 = this.getWritableDatabase();
        Cursor cursor = database2.rawQuery("Select * from category",null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setCategoryID(cursor.getInt(0)+"");
                categoryModel.setCategoryname(cursor.getString(1));
                categoryModels.add(categoryModel);
            }
        }
        cursor.close();
        database2.close();
        return categoryModels;
    }

    public Cursor getCategoryById(int id){
        SQLiteDatabase database2=this.getWritableDatabase();
        Cursor cursor = database2.rawQuery("Select * from category where id="+id,null);
        if(cursor !=null){
            cursor.moveToFirst();

        }
        return cursor;
    }


    public boolean updateCategory(int id , String category){
        SQLiteDatabase database2 = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("categoryname",category);
        long row = database2.update("category",values,"id="+id,null);
        if(row<=0){
            return false;
        }else {
            return true;
        }
    }






    public int deletecategory(String id){
        SQLiteDatabase database2=this.getWritableDatabase();
        return database2.delete("category","id="+id,null);
    }





}

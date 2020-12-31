package com.example.inertia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Subaru extends SQLiteOpenHelper {

   private static final String database = "database";
   private static final String ntable = "table";

     Subaru(Context context){
         super(context,database,null,4);

     }
    @Override
    public void onCreate(SQLiteDatabase db) {
         String table1 = "create table" +ntable+ "(id integer primary key, text Text)";
         db.execSQL(ntable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   db.execSQL(String.format("DROP TABLE IF EXISTS %s", ntable));
    onCreate(db);

    }
    public boolean addcomment (String text){
         SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("txt",text);
        sqLiteDatabase.insert(ntable, null,contentvalues);
        return true;
    }
    public ArrayList allcomment (){
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            ArrayList<String> arrayList = new ArrayList<String>();

        Cursor cursor = sqLiteDatabase.rawQuery("select *from " +ntable,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("txt")));
            cursor.moveToNext();
        }
        return arrayList;
    }


}

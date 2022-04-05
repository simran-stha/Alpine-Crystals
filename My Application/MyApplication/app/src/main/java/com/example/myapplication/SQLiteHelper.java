package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "USER_RECORD";
    public static final String Table_NAME = "USER_DATA";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "PASSWORD";

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + Table_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY, " + COL_2 + " VARCHAR, " + COL_3 + " VARCHAR, " + COL_4 + " VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_NAME);
        onCreate(db);

    }
}












//        public Boolean insertUserData(String username,String email,String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2,username);
//        contentValues.put(COL_3,email);
//        contentValues.put(COL_4,password);
//
//            long result = db.insert(Table_NAME, null, contentValues);
//            if(result == -1)
//                return false;
//            else
//                return true;
//        }






//    public Cursor getData(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("Select * from USER_DATA ",null);
//        return cursor;
//    }
//}
//

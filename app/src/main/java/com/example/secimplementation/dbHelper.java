package com.example.secimplementation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper{

    public dbHelper(Context context){
        super(context, "user table", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(  name text primary key, age text, gender text, email text, password text)");
        db.execSQL("create table userResult(id text primary key, result text)");

    }
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists userResult");

    }
    public boolean insertUserData(String name, String age, String gender, String email, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("gender", gender);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = db.insert("user",null, contentValues);
        if(result == -1)
            return false;
        else
            return true;


    }
    public boolean insertResults(String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", name);
        contentValues.put("result","0");


        long check = db.insert("userResult",null, contentValues);
        if(check == -1)
            return false;
        else
            return true;


    }

    public boolean updateResultsData(String id, String result){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("result", result);
        Cursor cursor = db.rawQuery("select * from userResult where id = ?",new String[]{id});
        if(cursor.getCount()>0) {


            long check = db.update("userResult", contentValues, "id = ?", new String[]{id});
            if (check == -1)
                return false;
            else
                return true;

        }
        return true;


    }
    public Cursor getdata(String id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from userResult where id = ?",new String[]{id});
        if(cursor.getCount()>0) {

            return cursor;


        }
        return null;


    }


}

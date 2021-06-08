package com.example.secimplementation;

import android.nfc.NfcAdapter;

import java.io.Serializable;

public class account implements Serializable {
    private String name;
    public account(String name){
        this.name = name;
    }
    public String getName(){
        return  this.name;
    }

    public void getData(dbHelper db,String name, String age,String gender, String email, String password){
        register(db,name, age, gender, email, password);

    }
    private boolean register(dbHelper db ,String name, String age, String gender, String email, String password){

        boolean flag1= db.insertUserData(name, age, gender, email, password);
        boolean flag =db.insertResults(name);
        if(flag && flag1)
            return true;
        return false;


    }

}

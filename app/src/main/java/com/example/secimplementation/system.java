package com.example.secimplementation;

import android.database.Cursor;

public class system {



    public static String[] getData(dbHelper db,String answer1, String answer2,String name){
       return assesDataAndCompileResult(db,answer1,answer2,name);

    }
    public static String[] assesDataAndCompileResult(dbHelper db,String answer1, String answer2, String name){
        int a = Integer.valueOf(answer1);
        int b = Integer.valueOf(answer2);
        String sum = Integer.toString(a+b);
        boolean flag =db.updateResultsData(name,sum );
        Cursor c = db.getdata(name);

        if(flag)
           if(c != null){
               c.moveToFirst();

               String result = c.getString(1);
              return choosevideos(result);
           }
        return null;




    }
    public static String[] choosevideos(String result){

        String [] selectedVids = new String[3];
        int r = Integer.valueOf(result);
        if(r > 6 && r <=8){
            selectedVids[1] = "HZsNjPFOg-s";
            selectedVids[2] = "dKnz0u4P6NE";
            selectedVids[3] = "1sY22O_rBVQ";

            return selectedVids;
        }else if(r >4 && r<=6){
            selectedVids[1] = "dKnz0u4P6NE";
            selectedVids[2] = "1sY22O_rBVQ";
            selectedVids[3] = "HZsNjPFOg-s";


        }else if(r>2 && r<=4){
            selectedVids[1] = "HZsNjPFOg-s";
            selectedVids[2]= "1sY22O_rBVQ";
            selectedVids[3] = "dKnz0u4P6NE";

        }

        return null;


    }
}

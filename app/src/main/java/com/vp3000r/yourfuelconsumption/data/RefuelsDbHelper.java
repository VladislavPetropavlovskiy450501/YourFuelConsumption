package com.vp3000r.yourfuelconsumption.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;


import java.sql.Date;

public class RefuelsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "refuels.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "refuels"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_FUELLVLBEFORE = "fuelLVLbefore";

    public static final String COLUMN_FUELADDED= "fueladded";
    public static final String COLUMN_COST= "cost";
    public static final String COLUMN_ODO= "odometr";

    public RefuelsDbHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+ TABLE +" ( " +
                " "+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+COLUMN_DATE+" STRING, " +
                " "+COLUMN_FUELLVLBEFORE+" DOUBLE, " +
                " "+COLUMN_FUELADDED+" DOUBLE, " +
                " "+COLUMN_COST+" DOUBLE, " +
                " "+COLUMN_ODO +" DOUBLE )";
        db.execSQL(sql);



    }

    public void insertData(String date, double fuelbefore, double fueladded, double cost, double odometr){
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("INSERT INTO "+TABLE+" ("+COLUMN_DATE+", "+COLUMN_FUELLVLBEFORE+", "+COLUMN_FUELADDED+", "+COLUMN_COST+", "+COLUMN_ODO+") " +
                "VALUES (?,?, ?, ?, ?)");
        stmt.bindString(1,date);
        stmt.bindDouble(2, fuelbefore);
        stmt.bindDouble(3, fueladded);
        stmt.bindDouble(4, cost);
        stmt.bindDouble(5, odometr);
        stmt.execute();

        stmt.close();
        db.close();
    }


    public double readFuel (String date)
    {
        double fuelcons=0;

        double fueladded=0;
        double startfuel, endfuel=0, startodo=0, endodo=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COLUMN_DATE+", "+COLUMN_FUELLVLBEFORE+", "+COLUMN_FUELADDED+", "+COLUMN_COST+", "+COLUMN_ODO+" FROM "+TABLE+" WHERE "+COLUMN_DATE+" > ?";
        Cursor cursor = db.rawQuery(query, new String[] {date});
        cursor.moveToFirst();
        startfuel=cursor.getDouble(1);
        startodo=cursor.getDouble(4);
        fueladded+=cursor.getDouble(2);
        while (cursor.moveToNext())
        {
            fueladded+=cursor.getDouble(2);
            endodo=cursor.getDouble(4);
            endfuel=cursor.getDouble(1);
        }
        cursor.moveToLast();
        fueladded-=cursor.getDouble(2);
        fuelcons=100*(fueladded+startfuel-endfuel)/(endodo-startodo);
        return fuelcons;
    }

    public double readMoney (String date)
    {


        double moneyspended=0;

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COLUMN_DATE+", "+COLUMN_FUELLVLBEFORE+", "+COLUMN_FUELADDED+", "+COLUMN_COST+", "+COLUMN_ODO+" FROM "+TABLE+" WHERE "+COLUMN_DATE+" > ?";
        Cursor cursor = db.rawQuery(query, new String[] {date});
        cursor.moveToFirst();
        moneyspended+=cursor.getDouble(3);

        while (cursor.moveToNext())
        {
            moneyspended+=cursor.getDouble(3);

        }

        return moneyspended;
    }



    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}
}
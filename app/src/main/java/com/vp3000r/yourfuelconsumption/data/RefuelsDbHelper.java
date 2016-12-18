package com.vp3000r.yourfuelconsumption.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;


import java.sql.Date;

/**
 * Класс для работы с базой заправок
 */
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

    /**
     * Занесение @param date, @param fuelbefore, @param fueladded, @param cost заправки, показаний @param odometr во время заправки в базу
     */
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

    /**
     * Чтение всех заправок после @param date и подсчет  @return fuelConsumtion за этот период
     */
    public double readFuel (String date)
    {
        double fuelCons=0;

        double fuelAdded=0;
        double startFuel, endFuel=0, startOdo=0, endOdo=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COLUMN_DATE+", "+COLUMN_FUELLVLBEFORE+", "+COLUMN_FUELADDED+", "+COLUMN_COST+", "+COLUMN_ODO+" FROM "+TABLE+" WHERE "+COLUMN_DATE+" > ?";
        Cursor cursor = db.rawQuery(query, new String[] {date});
        cursor.moveToFirst();
        startFuel=cursor.getDouble(1);
        startOdo=cursor.getDouble(4);
        fuelAdded+=cursor.getDouble(2);
        while (cursor.moveToNext())
        {
            fuelAdded+=cursor.getDouble(2);
            endOdo=cursor.getDouble(4);
            endFuel=cursor.getDouble(1);
        }
        cursor.moveToLast();
        fuelAdded-=cursor.getDouble(2);
        fuelCons=100*(fuelAdded+startFuel-endFuel)/(endOdo-startOdo);
        return fuelCons;
    }
    /**
     * Чтение всех заправок после @param date и подсчет  @return moneySpended за этот период
     */
    public double readMoney (String date)
    {
        double moneySpended=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COLUMN_DATE+", "+COLUMN_FUELLVLBEFORE+", "+COLUMN_FUELADDED+", "+COLUMN_COST+", "+COLUMN_ODO+" FROM "+TABLE+" WHERE "+COLUMN_DATE+" > ?";
        Cursor cursor = db.rawQuery(query, new String[] {date});
        cursor.moveToFirst();
        moneySpended+=cursor.getDouble(3);

        while (cursor.moveToNext())
        {
            moneySpended+=cursor.getDouble(3);
        }
        return moneySpended;
    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}
}
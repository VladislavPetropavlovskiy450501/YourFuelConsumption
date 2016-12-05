package com.vp3000r.yourfuelconsumption.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.vp3000r.yourfuelconsumption.PricesView;

public class PricesDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "prices.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "prices"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FUELID = "fuelID";
    public static final String COLUMN_PRICE = "price";

    public PricesDbHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+ TABLE +" ( " +
                " "+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+COLUMN_FUELID+" INTEGER, " +
                " "+COLUMN_PRICE +" DOUBLE )";
        db.execSQL(sql);



    }

    public void insertData(){
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("INSERT INTO "+TABLE+" ("+COLUMN_FUELID+", "+COLUMN_PRICE+") " +
                "VALUES (?,?)");
        stmt.bindLong(1, 0);
        stmt.bindDouble(2, 2.23);
        stmt.execute();
        stmt.bindLong(1, 1);
        stmt.bindDouble(2, 2.38);
        stmt.execute();
        stmt.bindLong(1, 2);
        stmt.bindDouble(2, 2.11);
        stmt.execute();
        stmt.bindLong(1, 3);
        stmt.bindDouble(2, 2.19);
        stmt.execute();
        stmt.bindLong(1, 4);
        stmt.bindDouble(2, 1.63);
        stmt.execute();
        stmt.bindLong(1, 5);
        stmt.bindDouble(2, 1.65);
        stmt.execute();
        stmt.close();
        db.close();
    }
    public void writePricesInBase (double ai92, double ai95, double dt, double dtarctic, double gas, double adblue)
    {
        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(TABLE, COLUMN_FUELID+" = ?", new String[] {"5"});
        db.delete(TABLE, COLUMN_FUELID+" = ?", new String[] {"4"});
        db.delete(TABLE, COLUMN_FUELID+" = ?", new String[] {"3"});
        db.delete(TABLE, COLUMN_FUELID+" = ?", new String[] {"2"});
        db.delete(TABLE, COLUMN_FUELID+" = ?", new String[] {"1"});
        db.delete(TABLE, COLUMN_FUELID+" = ?", new String[] {"0"});

        SQLiteStatement stmt = db.compileStatement("INSERT INTO "+TABLE+" ("+COLUMN_FUELID+", "+COLUMN_PRICE+") " +
                "VALUES (?,?)");

        stmt.bindLong(1, 0);
        stmt.bindDouble(2, dt);
        stmt.execute();

        stmt.bindLong(1, 1);
        stmt.bindDouble(2, dtarctic);
        stmt.execute();

        stmt.bindLong(1, 2);
        stmt.bindDouble(2, ai92);
        stmt.execute();

        stmt.bindLong(1, 3);
        stmt.bindDouble(2, ai95);
        stmt.execute();

        stmt.bindLong(1, 4);
        stmt.bindDouble(2, gas);
        stmt.execute();

        stmt.bindLong(1, 5);
        stmt.bindDouble(2, adblue);
        stmt.execute();
        stmt.close();
        db.close();



    }
    public double readFuelPrice(int kind){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COLUMN_ID+", "+COLUMN_FUELID+", "+COLUMN_PRICE+" FROM "+TABLE+" WHERE "+COLUMN_FUELID+" = ?";
        Cursor cursor = db.rawQuery(query, new String[] {String.valueOf(kind)});
        cursor.moveToFirst();
       double d = cursor.getDouble(2);
        db.close();
        return d;
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}
}
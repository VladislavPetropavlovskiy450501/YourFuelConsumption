package com.vp3000r.yourfuelconsumption;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vp3000r.yourfuelconsumption.data.PricesDbHelper;

import org.htmlcleaner.TagNode;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Model {
    static Context context;
    static PricesDbHelper pricesDBhelper;

    Model(Context c) {
        context = c;
        pricesDBhelper = new PricesDbHelper(context);
        File dbtest = new File("/data/data/com.vp3000r.yourfuelconsumption/databases/prices.db");
        if (dbtest.exists()) {

        } else {
            createDB(pricesDBhelper);
            pricesDBhelper.insertData();
        }


    /*
    if(pdbh.getReadableDatabase()==null)
    {

    }*/
    }


    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    public static boolean createDB(PricesDbHelper pdbh1) {


        pdbh1 = new PricesDbHelper(context);
        return true;


    }


    public static double send92() {


        return pricesDBhelper.readFuelPrice(2);


    }

    public static double send95() {
        return pricesDBhelper.readFuelPrice(3);
    }

    public static double senddt() {
        return pricesDBhelper.readFuelPrice(0);
    }

    public static double senddtarctic() {
        return pricesDBhelper.readFuelPrice(1);
    }

    public static double sendgas() {
        return pricesDBhelper.readFuelPrice(4);
    }

    public static double sendadblue() {
        return pricesDBhelper.readFuelPrice(5);
    }

    public static void refreshPrices() {
        new ParseSite().execute("http://sgonay.ucoz.com/index/0-109");

    }

    public static void writePrices(List<String> strprices)
    {
        double ai92, ai95, dt, dtarctic, gas, adblue;
        BigDecimal bd;
        bd =new BigDecimal(Float.valueOf(strprices.get(7)));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        dt = bd.doubleValue();
        bd =new BigDecimal(Float.valueOf(strprices.get(8)));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        dtarctic = bd.doubleValue();
        bd =new BigDecimal(Float.valueOf(strprices.get(9)));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        ai92 = bd.doubleValue();
        bd =new BigDecimal(Float.valueOf(strprices.get(10)));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        ai95 = bd.doubleValue();
        bd =new BigDecimal(Float.valueOf(strprices.get(11)));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        gas = bd.doubleValue();
        bd =new BigDecimal(Float.valueOf(strprices.get(12)));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        adblue = bd.doubleValue();
        pricesDBhelper.writePricesInBase(ai92, ai95, dt, dtarctic, gas, adblue);

    }

    public static double sendMoney(int period) {
        if (period == 0) return 18.45;
        else if (period == 1) return 50.00;
        else return 1200;
    }

    public static double sendFuel(int period) {
        if (period == 0) return 7.3;
        else if (period == 1) return 6.9;
        else return 7.2;
    }

    public static void addRefuel(double litres, double cost, double fuellevel, double odometr, double fuelprice) {


    }





}

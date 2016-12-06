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
import com.vp3000r.yourfuelconsumption.data.RefuelsDbHelper;

import org.htmlcleaner.TagNode;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Model {
    static Context context;
    static PricesDbHelper pricesDBhelper;
    static RefuelsDbHelper refuelsDBhelper;

    Model(Context c) {
        context = c;
        pricesDBhelper = new PricesDbHelper(context);

        File dbtest = new File("/data/data/com.vp3000r.yourfuelconsumption/databases/prices.db");
        if (dbtest.exists()) {

        } else {

            pricesDBhelper.insertData();
        }

    }
    Model(Context c, int a) {
        context = c;
        refuelsDBhelper = new RefuelsDbHelper(context);

        File dbtest = new File("/data/data/com.vp3000r.yourfuelconsumption/databases/refuels.db");
        if (dbtest.exists()) {

        } else {


        }

    }

    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;




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
        double cons;
        Date targetdate = new Date();


        if (period == 0) {
            targetdate.setDate(targetdate.getDate()-7);
        }

        else if (period == 1)
        {
            targetdate.setMonth(targetdate.getMonth()-1);
        }

        else
        {
            targetdate.setYear(targetdate.getYear()-1);
        };
        String month;
        String day;
        if (targetdate.getMonth()<10) month = "0"+String.valueOf(targetdate.getMonth()); else month = String.valueOf(targetdate.getMonth());
        if (targetdate.getDate()<10) day = "0"+String.valueOf(targetdate.getDate()); else day = String.valueOf(targetdate.getDate());
        String targetdatecomparible = String.valueOf(targetdate.getYear())+month+day;
        cons=refuelsDBhelper.readMoney(targetdatecomparible);

        BigDecimal bd = new BigDecimal(cons);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static double sendFuel(int period) {
        double cons;
        Date targetdate = new Date();


        if (period == 0) {
           targetdate.setDate(targetdate.getDate()-7);
        }

        else if (period == 1)
        {
            targetdate.setMonth(targetdate.getMonth()-1);
        }

        else
        {
            targetdate.setYear(targetdate.getYear()-1);
        };
        String month;
        String day;
        if (targetdate.getMonth()<10) month = "0"+String.valueOf(targetdate.getMonth()); else month = String.valueOf(targetdate.getMonth());
        if (targetdate.getDate()<10) day = "0"+String.valueOf(targetdate.getDate()); else day = String.valueOf(targetdate.getDate());
        String targetdatecomparible = String.valueOf(targetdate.getYear())+month+day;
        cons=refuelsDBhelper.readFuel(targetdatecomparible);

        BigDecimal bd = new BigDecimal(cons);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static void addRefuel(double litres, double cost, double fuellevel, double odometr, double fuelprice) {
        Date date = new Date();
        BigDecimal bd;
        bd =new BigDecimal(65*fuellevel);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        fuellevel =  bd.doubleValue();
        if (cost==0) cost = fuelprice*litres; else litres = cost/fuelprice;
        bd =new BigDecimal(cost);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        cost =  bd.doubleValue();
        bd =new BigDecimal(litres);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        litres =  bd.doubleValue();
        String month;
        String day;
        if (date.getMonth()<10) month = "0"+String.valueOf(date.getMonth()); else month = String.valueOf(date.getMonth());
        if (date.getDate()<10) day = "0"+String.valueOf(date.getDate()); else day = String.valueOf(date.getDate());
        String datecomparible = String.valueOf(date.getYear())+month+day;
        refuelsDBhelper.insertData(datecomparible, fuellevel, litres, cost, odometr);

    }





}

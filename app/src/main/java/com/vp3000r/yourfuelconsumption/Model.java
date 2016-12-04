package com.vp3000r.yourfuelconsumption;

/**
 * Created by P on 21.11.16.
 */
public class Model {


    public static double send92()
    {
        return 1.11;
    }
    public static double send95()
    {
        return 1.19;
    }
    public static double senddt()
    {
        return 1.23;
    }
    public static double senddtarctic()
    {
        return 1.38;
    }
    public static double sendgas()
    {
        return 1.63;
    }
    public static double sendadblue()
    {
        return 0.65;
    }
    public static void refreshPrices()
    {

    }
    public static double sendMoney(int period)
    {
        if  (period==0) return 18.45;
        else if (period==1) return 50.00;
        else return 1200;
    }
    public static double sendFuel(int period)
    {
        if  (period==0) return 7.3;
        else if (period==1) return 6.9;
        else return 7.2;
    }
    public static void addRefuel (double litres, double cost, double fuellevel, double odometr, double fuelprice)
    {


    }

}

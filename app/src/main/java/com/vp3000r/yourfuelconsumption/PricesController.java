package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Created by P on 21.11.16.
 */
public class PricesController extends Controller {

    double ai92, ai95, dt, dtarctic, gas, adblue;


    PricesController (Context context)
    {
        Model model = new Model(context);
        ai92 = Model.send92();
        ai95 = Model.send95();
        dt = Model.senddt();
        dtarctic = Model.senddtarctic();
        gas = Model.sendgas();
        adblue = Model.sendadblue();
    }

    public static void refreshprices()
    {
        Model.refreshPrices();
    }

    public double sendPrice(int fuelkind, Context context){
    double price=0;
        Model model = new Model(context);
       switch (fuelkind)
       {

           case 0: {price = Model.senddt();break;}
           case 1: {price = Model.senddtarctic();break;}
           case 2: {price = Model.send92();break;}
           case 3: {price = Model.send95();break;}
           case 4: {price = Model.sendgas();break;}
           case 5: {price = Model.sendadblue();break;}

       }
    return price;

    }

}

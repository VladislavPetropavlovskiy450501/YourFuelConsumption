package com.vp3000r.yourfuelconsumption;

/**
 * Created by P on 21.11.16.
 */
public class PricesController extends Controller {

    double ai92, ai95, dt, dtarctic, gas, adblue;

    PricesController ()
    {
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

    public Object sendPrice(){

        return 1.23;


    };

}

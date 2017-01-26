package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Класс, предоставляющий данные для окна цен
 */
public class PricesController extends Controller {

    double ai92, ai95, dt, dtarctic, gas, adblue;


    PricesController (Context context)
    {
        Model model = new Model(context);
        ai92 = Model.sendPrice(2);
        ai95 = Model.sendPrice(3);
        dt = Model.sendPrice(0);
        dtarctic = Model.sendPrice(1);
        gas = Model.sendPrice(4);
        adblue = Model.sendPrice(5);
    }

    public static void refreshPrices()
    {
        Model.refreshPrices();
    }

    /**
     * Метод запрашивает цены на топливо и отправляет их через адаптер в класс, обрабатывающий заправку
     * @param fuelKind - тип топлива
     */

    public double sendPrice(int fuelKind, Context context){
    double price=0;
        Model model = new Model(context);
        price = Model.sendPrice(fuelKind);
    return price;

    }

}

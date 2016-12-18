package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Created by P on 21.11.16.
 */
public class ConsumtionController extends Controller {
    double moneyWeek, moneyMonth, moneyYear, fuelWeek, fuelMonth, fuelYear, target;
    ConsumtionController(Context c)
{
    Model model = new Model(c, 0);
    moneyWeek = Model.sendMoney(0);
    moneyMonth = Model.sendMoney(1);
    moneyYear = Model.sendMoney(2);
    fuelWeek = model.sendFuel(0);
    fuelMonth = model.sendFuel(1);
    fuelYear = model.sendFuel(2);
    StrategyContext context = new StrategyContext();

    if (fuelWeek>7) {
        context.setStrategy(new StrategyMorethan7());
        target = context.executeStrategy(fuelWeek);
    }
    else {
        context.setStrategy(new StrategyLessthan7());
        target = context.executeStrategy(fuelWeek);
    }

}

}


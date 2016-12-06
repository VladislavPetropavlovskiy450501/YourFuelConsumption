package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Created by P on 21.11.16.
 */
public class ConsumtionController extends Controller {
    double moneyweek, moneymonth, moneyyear, fuelweek, fuelmonth, fuelyear, target;
    ConsumtionController(Context c)
{
    Model model = new Model(c, 0);
    moneyweek = Model.sendMoney(0);
    moneymonth = Model.sendMoney(1);
    moneyyear = Model.sendMoney(2);
    fuelweek = model.sendFuel(0);
    fuelmonth = model.sendFuel(1);
    fuelyear = model.sendFuel(2);
    StrategyContext context = new StrategyContext();

    if (fuelweek>7) {
        context.setStrategy(new StrategyMorethan7());
        target = context.executeStrategy(fuelweek);
    }
    else {
        context.setStrategy(new StrategyLessthan7());
        target = context.executeStrategy(fuelweek);
    }

}

}


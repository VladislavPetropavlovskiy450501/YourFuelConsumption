package com.vp3000r.yourfuelconsumption;

/**
 * Created by P on 21.11.16.
 */
public class ConsumtionController extends Controller {
    double moneyweek, moneymonth, moneyyear, fuelweek, fuelmonth, fuelyear, target;
    ConsumtionController()
{
    moneyweek = Model.sendMoney(0);
    moneymonth = Model.sendMoney(1);
    moneyyear = Model.sendMoney(2);
    fuelweek = Model.sendFuel(0);
    fuelmonth = Model.sendFuel(1);
    fuelyear = Model.sendFuel(2);
    Context context = new Context();

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


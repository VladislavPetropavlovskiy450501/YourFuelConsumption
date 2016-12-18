package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Обработка действий, происходящих в окне расходов. Запрос данных о расходах из модели.
 */
public class ConsumtionController extends Controller {
    double moneyWeek, moneyMonth, moneyYear, fuelWeek, fuelMonth, fuelYear, target;
    ConsumtionController(Context c)
{
    Model model = new Model(c, 0);
    moneyWeek = Model.sendMoney(0);
    moneyMonth = Model.sendMoney(1);
    moneyYear = Model.sendMoney(2);
    fuelWeek = model.sendFuelConsumption(0);
    fuelMonth = model.sendFuelConsumption(1);
    fuelYear = model.sendFuelConsumption(2);
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


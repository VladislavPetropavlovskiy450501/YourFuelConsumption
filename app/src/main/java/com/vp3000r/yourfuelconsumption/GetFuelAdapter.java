package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Адаптер для передачи цен на топливо из соответствующего им класса в класс, обрабатывающий заправку
 */
public class GetFuelAdapter extends PricesController implements GetFuel {
    GetFuelAdapter(Context context) {
        super(context);
    }

    public double getFuel(int fuelkind, Context context) {
     return sendPrice(fuelkind, context);

    };
}

package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Created by P on 01.12.16.
 */
public class GetFuelAdapter extends PricesController implements GetFuel {
    GetFuelAdapter(Context context) {
        super(context);
    }

    public double getFuel(int fuelkind, Context context) {
     return sendPrice(fuelkind, context);

    };
}

package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Created by P on 21.11.16.
 */
public class RefuelController extends Controller {


    RefuelController (double litres, double cost, double fuellevel, double odometr, int fuelkind, Context context)
    {
        GetFuel gf = new GetFuelAdapter(context);
        double fuelprice = gf.getFuel(fuelkind, context);

        Model.addRefuel(litres, cost, fuellevel, odometr, fuelprice);

    }



}

package com.vp3000r.yourfuelconsumption;

import android.content.Context;

/**
 * Created by P on 21.11.16.
 */
public class RefuelController extends Controller {


    RefuelController (double litres, double cost, double fuelLevel, double odometr, int fuelKind, Context context)
    {
        GetFuel gf = new GetFuelAdapter(context);
        double fuelPrice = gf.getFuel(fuelKind, context);
        Model model = new Model (context, 0);
        model.addRefuel(litres, cost, fuelLevel, odometr, fuelPrice);

    }



}

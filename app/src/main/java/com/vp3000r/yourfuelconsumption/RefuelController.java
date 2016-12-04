package com.vp3000r.yourfuelconsumption;

/**
 * Created by P on 21.11.16.
 */
public class RefuelController extends Controller {


    RefuelController (double litres, double cost, double fuellevel, double odometr, int fuelkind)
    {
        GetFuel gf = new GetFuelAdapter();
        double fuelprice = gf.getFuel(fuelkind);

        Model.addRefuel(litres, cost, fuellevel, odometr, fuelprice);

    }



}

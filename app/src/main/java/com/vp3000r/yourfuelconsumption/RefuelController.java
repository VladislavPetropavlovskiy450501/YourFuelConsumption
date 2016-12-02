package com.vp3000r.yourfuelconsumption;

/**
 * Created by P on 21.11.16.
 */
public class RefuelController extends Controller {
    int kind=3;
    public static void addFuel(Object price)
    {

    }

    public static void main(String[] args)
    {
        GetFuel gf = new GetFuelAdapter();
        Object fuelprice = gf.getFuel();
        addFuel(fuelprice);

    }


}

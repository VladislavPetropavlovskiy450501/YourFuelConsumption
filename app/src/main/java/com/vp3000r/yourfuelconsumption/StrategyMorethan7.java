package com.vp3000r.yourfuelconsumption;



/**
 * Created by P on 01.12.16.
 */

class StrategyMorethan7 implements Strategy  {

    public double execute (double fuelCons)
    {
        double target = fuelCons-0.1;
        return target;
    }

}

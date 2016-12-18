package com.vp3000r.yourfuelconsumption;

import java.math.BigDecimal;

/**
 * Created by P on 01.12.16.
 */
class StrategyLessthan7 implements Strategy {
    public double execute (double fuelCons)
    {
        double target = fuelCons*0.993;
        BigDecimal targetBD = new BigDecimal(target);
        targetBD = targetBD.setScale(2, BigDecimal.ROUND_HALF_UP);
        target = targetBD.doubleValue();
        return target;
    }
}

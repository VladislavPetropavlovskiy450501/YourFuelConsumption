package com.vp3000r.yourfuelconsumption;


import java.math.BigDecimal;


class StrategyMorethan7 implements Strategy  {
    /**
     * Метод рассчитывает задачу по расходу топлива на следующую неделю, если
     * @param fuelCons (расход топлива за неделю на данный момент) меньше 7л/100км
     */
    public double execute (double fuelCons)
    {
        double target = fuelCons-0.1;
        BigDecimal targetBD = new BigDecimal(target);
        targetBD = targetBD.setScale(2, BigDecimal.ROUND_HALF_UP);
        target = targetBD.doubleValue();
        return target;
    }

}

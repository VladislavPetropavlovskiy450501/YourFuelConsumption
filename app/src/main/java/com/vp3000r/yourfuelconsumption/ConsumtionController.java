package com.vp3000r.yourfuelconsumption;

/**
 * Created by P on 21.11.16.
 */
public class ConsumtionController extends Controller {



    public static void main(String[] args) {
        double fuelCons=7.2;
        Context context = new Context();

        if (fuelCons>7) {
            context.setStrategy(new StrategyMorethan7());
            double target = context.executeStrategy(fuelCons);
        }
        else {
            context.setStrategy(new StrategyLessthan7());
            double target = context.executeStrategy(fuelCons);
        }
        }
}

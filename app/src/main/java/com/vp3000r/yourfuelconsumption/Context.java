package com.vp3000r.yourfuelconsumption;

/**
 * Created by P on 01.12.16.
 */
public class Context {

    private Strategy strategy;

    // Constructor
    public Context() {
    }

    // Set new strategy
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double fuelCons) {
        return strategy.execute(fuelCons);
    }
}
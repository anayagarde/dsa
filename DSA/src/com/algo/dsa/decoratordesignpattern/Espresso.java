package com.algo.dsa.decoratordesignpattern;

public class Espresso implements Coffee {

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public Double getCost() { // Base Espresso cost
        return 1.99;
    }
}
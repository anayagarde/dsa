package com.algo.dsa.decoratordesignpattern;

public class Sugar extends CoffeeDecorator {

    Coffee coffee;

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public Double getCost() {
        return coffee.getCost() + 0.25;
    }
}

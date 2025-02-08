package com.algo.dsa.decoratordesignpattern;

public class Milk extends CoffeeDecorator {

    Coffee coffee;

    public Milk(Coffee coffee) {
       this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public Double getCost() {
        return coffee.getCost() + 0.50;
    }
}
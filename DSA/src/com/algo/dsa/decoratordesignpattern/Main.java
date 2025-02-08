package com.algo.dsa.decoratordesignpattern;

public class Main {

    public static void main(String[] args) {
        Coffee espresso = new Espresso();
        System.out.println("Description: " + espresso.getDescription());
        System.out.println("Cost: " + espresso.getCost());
        // base espresso with no ingredients

        // Let's add Milk to it
        espresso = new Milk(espresso);
        System.out.println("After adding 1 x Milk:");
        System.out.println("Description: " + espresso.getDescription());
        System.out.println("Cost: " + espresso.getCost());

        // Let's add Sugar to it
        espresso = new Sugar(espresso);
        espresso = new Sugar(espresso);
        System.out.println("After adding 2 x Sugar:");
        System.out.println("Description: " + espresso.getDescription());
        System.out.println("Cost: " + espresso.getCost());

    }
}

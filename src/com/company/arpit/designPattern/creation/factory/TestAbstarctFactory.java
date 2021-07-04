package com.company.arpit.designPattern.creation.factory;

public class TestAbstarctFactory {
    public static void main(String[] args) {
        System.out.println(AbstractFactory.getDetails("Jeep"));
        System.out.println(AbstractFactory.getDetails("Car"));

    }
}

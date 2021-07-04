package com.company.arpit.designPattern.creation.factory;

public class TestFactoryMethod {

    public static void main(String[] args) {
        CarFactory carFactory =new CarFactory();
       System.out.println( carFactory.getCar("Maruti"));
    }
}

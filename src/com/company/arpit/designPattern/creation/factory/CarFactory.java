package com.company.arpit.designPattern.creation.factory;

public class CarFactory {

    public Car getCar(String name) {
        if (name.equals("Hyundai"))
            return new Hyundai();

        if (name.equals("Audi"))
            return new Audi();

        if (name.equals("BMW"))
            return new BMW();

        if (name.equals("Maruti"))
            return new Maruti();

        return null;
    }
}

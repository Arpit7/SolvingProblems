package com.company.arpit.designPattern.creation.factory;

public class AbstractFactory {
    public  static String getDetails(String factoryType)
    {
        switch (factoryType){
            case "Jeep":
                return new JeepFactory().getJeep("TataJeep").getDetails();
            case "Car":
                return new CarFactory().getCar("Maruti").getCarName();
        }
    return null;
    }
}

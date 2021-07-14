package com.company.arpit.designPattern.creation.factory;

public class JeepFactory {

    public Jeep getJeep(String jeepType)
    {
        switch (jeepType){
            case "MarutiJeep":
                return new MarutiJeep();
            case "TataJeep":
                return new TataJeep();
        }
        return null;
    }
}

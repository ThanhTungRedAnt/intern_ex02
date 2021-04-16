package com.intern.dto.car;

public class MediumCar extends Car {
    private boolean havePowerSteering;

    public MediumCar(String numberPlate, String nameCar, int yearManufacture, Brand brand, boolean haveInsurance, boolean havePowerSteering) {
        super(numberPlate, nameCar, TypeCar.MediumCar, yearManufacture, brand, haveInsurance);
        this.setHavePowerSteering(havePowerSteering);
    }

    public boolean isHavePowerSteering() {
        return havePowerSteering;
    }

    public void setHavePowerSteering(boolean havePowerSteering) {
        this.havePowerSteering = havePowerSteering;
    }

}

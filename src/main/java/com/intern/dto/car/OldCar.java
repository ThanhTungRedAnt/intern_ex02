package com.intern.dto.car;

public class OldCar extends Car {
    private int actionDuration;

    public OldCar(String numberPlate, String nameCar, int yearManufacture, Brand brand, boolean haveInsurance, int actionDuration) {
        super(numberPlate, nameCar, TypeCar.OldCar, yearManufacture, brand, haveInsurance);
        this.setActionDuration(actionDuration);
    }

    public int getActionDuration() {
        return actionDuration;
    }

    public void setActionDuration(int actionDuration) {
        this.actionDuration = actionDuration;
    }

}

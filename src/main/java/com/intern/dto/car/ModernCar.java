package com.intern.dto.car;

public class ModernCar extends Car {
    private boolean havePositioning;

    public ModernCar(String numberPlate, String nameCar, int yearManufacture, Brand brand, boolean haveInsurance, boolean havePositioning) {
        super(numberPlate, nameCar, TypeCar.ModernCar, yearManufacture, brand, haveInsurance);
        this.setHavePositioning(havePositioning);
    }

    public boolean isHavePositioning() {
        return havePositioning;
    }

    public void setHavePositioning(boolean havePositioning) {
        this.havePositioning = havePositioning;
    }

}

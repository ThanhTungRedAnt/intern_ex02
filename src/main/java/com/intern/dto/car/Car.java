package com.intern.dto.car;

public abstract class Car {
    private String numberPlate;
    private String nameCar;
    private TypeCar typeCar;
    private int yearManufacture;
    private Brand brand;
    private boolean haveInsurance;

    public Car(String numberPlate, String nameCar, TypeCar typeCar, int yearManufacture, Brand brand, boolean haveInsurance) {
        this.numberPlate = numberPlate;
        this.nameCar = nameCar;
        this.typeCar = typeCar;
        this.yearManufacture = yearManufacture;
        this.brand = brand;
        this.haveInsurance = haveInsurance;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isHaveInsurance() {
        return haveInsurance;
    }

    public void setHaveInsurance(boolean haveInsurance) {
        this.haveInsurance = haveInsurance;
    }
}

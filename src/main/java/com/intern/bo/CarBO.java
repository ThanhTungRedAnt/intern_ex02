package com.intern.bo;

public class CarBO {
    private String numberPlate;
    private String nameCar;
    private String typeCar;
    private int yearManufacture;
    private String brand;
    private int haveInsurance;
    private int havePositioning;
    private int havePowerSteering;
    private int actionDuration;

    public CarBO() {
    }

    public CarBO(String numberPlate, String nameCar, String typeCar, int yearManufacture, String brand, int haveInsurance, int havePositioning, int havePowerSteering, int actionDuration) {
        this.numberPlate = numberPlate;
        this.nameCar = nameCar;
        this.typeCar = typeCar;
        this.yearManufacture = yearManufacture;
        this.brand = brand;
        this.haveInsurance = haveInsurance;
        this.havePositioning = havePositioning;
        this.havePowerSteering = havePowerSteering;
        this.actionDuration = actionDuration;
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

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHaveInsurance() {
        return haveInsurance;
    }

    public void setHaveInsurance(int haveInsurance) {
        this.haveInsurance = haveInsurance;
    }

    public int getHavePositioning() {
        return havePositioning;
    }

    public void setHavePositioning(int havePositioning) {
        this.havePositioning = havePositioning;
    }

    public int getHavePowerSteering() {
        return havePowerSteering;
    }

    public void setHavePowerSteering(int havePowerSteering) {
        this.havePowerSteering = havePowerSteering;
    }

    public int getActionDuration() {
        return actionDuration;
    }

    public void setActionDuration(int actionDuration) {
        this.actionDuration = actionDuration;
    }

    @Override
    public String toString() {
        return nameCar + "   " + numberPlate + "   " + yearManufacture + "   " + typeCar + "   " + haveInsurance;
    }
}

package com.intern.service.car;

import com.intern.bo.CarBO;
import com.intern.dao.CarDAO;
import com.intern.dto.car.*;

import java.util.Random;

public class AddCarService {

    public AddCarService() {
    }

    public boolean addModernCar(ModernCar car) {
        CarBO bo = convertDTO2BO(car);
        bo.setHavePositioning(car.isHavePositioning() ? 1 : 0);

        CarDAO dao = new CarDAO();
        return dao.saveCar(bo);
    }

    public boolean addMediumCar(MediumCar car) {
        CarBO bo = convertDTO2BO(car);
        bo.setHavePowerSteering(car.isHavePowerSteering() ? 1 : 0);

        CarDAO dao = new CarDAO();
        return dao.saveCar(bo);
    }

    public boolean addOldCar(OldCar car) {
        CarBO bo = convertDTO2BO(car);
        bo.setActionDuration(car.getActionDuration());

        CarDAO dao = new CarDAO();
        return dao.saveCar(bo);
    }

    public int randomYearManufacture() {
        Random random = new Random();
        return 1980 + random.nextInt(33);
    }

    public int countCar() {
        return new CarDAO().countCar();
    }

    /*Cap nhat trang thai Xe da mua bao hiem*/
    public void updateHaveInsurance(String namePlate) {
        boolean isSuccess = new CarDAO().updateHaveInsurance(namePlate);
    }

    /*Kiem tra xe da co bao hiem hay chua*/
    public boolean checkHaveInsurance(String numberPlate) {
        return new CarDAO().checkHaveInsurance(numberPlate);
    }

    /*Kiem tra NumberPlate da ton tai hay chua*/
    public boolean checkNumberPlate(int number) {
        return new CarDAO().checkNumberPlate(number);
    }

    public Brand randomBrand() {
        int n = new Random().nextInt(Brand.values().length);
        return Brand.values()[n];
    }

    public String randomNumberPlate() {
        AddCarService add = new AddCarService();
        Random rd = new Random();
        int num = 10000 + rd.nextInt(90000);
        boolean c = add.checkNumberPlate(num);
        while (!c) {
            num = 10000 + rd.nextInt(90000);
            c = add.checkNumberPlate(num);
        }
        return String.valueOf(num);
    }

    public boolean randomBoolean() {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    public String randomNameCar(int i) {
        AddCarService addCar = new AddCarService();
        return String.format("Car #(%s+%s)", addCar.countCar(), i);
    }

    /*Convert tu DTO sang BO*/
    private static CarBO convertDTO2BO(Car dto) {
        CarBO bo = new CarBO();
        bo.setNumberPlate(dto.getNumberPlate());
        bo.setNameCar(dto.getNameCar());
        bo.setTypeCar(dto.getTypeCar().name());
        bo.setYearManufacture(dto.getYearManufacture());
        bo.setBrand(dto.getBrand().name());
        bo.setHaveInsurance(dto.isHaveInsurance() ? 1 : 0);

        return bo;
    }
}

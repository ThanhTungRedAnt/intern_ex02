package com.intern.service.ins;

import com.intern.bo.CarBO;
import com.intern.dao.CarDAO;
import com.intern.dto.car.TypeCar;
import com.intern.utils.DBUtils;

import java.sql.Connection;
import java.util.List;

public class GetCarService {
    private Connection conn;

    public GetCarService() {
        this.conn = DBUtils.getConnection();
    }

    public void showAllCarByType(String typeCar) {
        CarDAO dao = new CarDAO();
        List<CarBO> cars = dao.getAllCarByType(typeCar);
        System.out.println("NameCar   NumberPlate   YearManufacture   TypeCar   HaveInsurance");
        for (CarBO c : cars) {
            System.out.println(c.toString());
        }
    }

    public String showTypeCar(String numberPlate) {
        return new CarDAO().getTypeCar(numberPlate);
    }

    public void showModernCar() {
        this.showAllCarByType(TypeCar.ModernCar.name());
    }

    public void showMediumCar() {
        this.showAllCarByType(TypeCar.MediumCar.name());
    }

    public void showOldCar() {
        this.showAllCarByType(TypeCar.OldCar.name());
    }
}

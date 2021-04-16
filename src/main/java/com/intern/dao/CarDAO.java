package com.intern.dao;

import com.intern.bo.CarBO;
import com.intern.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private Connection conn;

    public CarDAO() {
        this.conn = DBUtils.getConnection();
    }

    public boolean saveCar(CarBO bo) {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO CAR (name_car, number_plate, type_car, year_of_manufacture, brand, have_insurance, have_positioning_device, have_power_steering, action_duration) ");
        sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement(sql.toString());
            cstmt.setString(1, bo.getNameCar());
            cstmt.setString(2, bo.getNumberPlate());
            cstmt.setString(3, bo.getTypeCar());
            cstmt.setInt(4, bo.getYearManufacture());
            cstmt.setString(5, bo.getBrand());
            cstmt.setInt(6, bo.getHaveInsurance());
            cstmt.setInt(7, bo.getHavePositioning());
            cstmt.setInt(8, bo.getHavePowerSteering());
            cstmt.setInt(9, bo.getActionDuration());

            return cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkNumberPlate(int number) {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("SELECT * FROM car WHERE number_plate=?");
            cstmt.setString(1, Integer.toString(number));
            ResultSet rs = cstmt.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int countCar() {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("SELECT count(*) FROM car");
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean updateHaveInsurance(String numberPlate) {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("UPDATE CAR SET have_insurance = 1 WHERE number_plate = ?");
            cstmt.setString(1, numberPlate);
            return cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkHaveInsurance(String numberPlate) {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("SELECT have_insurance FROM car WHERE number_plate = ?");
            cstmt.setString(1, numberPlate);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next() && rs.getBoolean(1)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*Lay DS car theo loai, typeCar = null -> lay tat ca*/
    public List<CarBO> getAllCarByType(String typeCar) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("   number_plate, ");
        sql.append("   name_car, ");
        sql.append("   type_car, ");
        sql.append("   year_of_manufacture, ");
        sql.append("   brand, ");
        sql.append("   have_insurance, ");
        sql.append("   have_positioning_device, ");
        sql.append("   have_power_steering, ");
        sql.append("   action_duration ");
        sql.append(" FROM car ");

        if (typeCar != null && typeCar.length() > 0) {
            sql.append(" WHERE type_car = ? ");
        }

        PreparedStatement cstmt;
        List<CarBO> dataRes = new ArrayList<CarBO>();
        try {
            cstmt = conn.prepareStatement(sql.toString());
            if (typeCar != null && typeCar.length() > 0) {
                cstmt.setString(1, typeCar);
            }

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                CarBO car = new CarBO();
                car.setNumberPlate(rs.getString(1));
                car.setNameCar(rs.getString(2));
                car.setTypeCar(rs.getString(3));
                car.setYearManufacture(rs.getInt(4));
                car.setBrand(rs.getString(5));
                car.setHaveInsurance(rs.getInt(6));
                car.setHavePositioning(rs.getInt(7));
                car.setHavePowerSteering(rs.getInt(8));
                car.setActionDuration(rs.getInt(9));

                dataRes.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataRes;
    }

    public String getTypeCar(String numberPlate) {
        PreparedStatement cstmt;
        try {
            cstmt = conn.prepareStatement("SELECT type_car from car where number_plate = ?");
            cstmt.setString(1, numberPlate);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            System.out.println("Car don't exists");
            return "";
        }
    }
}

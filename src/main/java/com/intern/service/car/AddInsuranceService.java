package com.intern.service.car;

import com.intern.bo.InsuranceBO;
import com.intern.dao.InsDAO;
import com.intern.dto.ins.Insurance;
import com.intern.dto.ins.TypeInsurance;

import java.util.Random;

public class AddInsuranceService {

    public AddInsuranceService() {
    }

    public void buyInsForCar(String insName, String numberPlate) {
        new InsDAO().updateInsNumberPlateByName(insName, numberPlate);
    }

    public void addIns(Insurance ins) {
        InsuranceBO bo = new InsuranceBO();
        bo.setName(ins.getNameInsurance());
        bo.setType(ins.getTypeInsurance().name());
        bo.setNumberPlate(ins.getNumberPlate());

        new InsDAO().saveIns(bo);
    }

    private int countInsurance() {
        return new InsDAO().countIns();
    }

    public TypeInsurance randomTypeInsurance() {
        int n = new Random().nextInt(TypeInsurance.values().length);
        return TypeInsurance.values()[n];
    }

    public String randomNameInsurance(int i) {
        AddInsuranceService addIns = new AddInsuranceService();
        return String.format("Insurance Package #(%s+%s)", addIns.countInsurance(), i);
    }
}

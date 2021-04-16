package com.intern.service.ins;

import com.intern.bo.InsuranceBO;
import com.intern.dao.InsDAO;

import java.util.List;

public class GetInsuranceService {

    public GetInsuranceService() {
    }

    public String getTypeByName(String nameIns) {
        return new InsDAO().getTypeIns(nameIns);
    }

    public void getInsuranceAvailable() {
        System.out.println("NameInsurance           TypeInsurance");
        List<InsuranceBO> ins = new InsDAO().getAvailableIns();

        for (InsuranceBO i : ins) {
            System.out.println(i.toString());
        }
    }
}

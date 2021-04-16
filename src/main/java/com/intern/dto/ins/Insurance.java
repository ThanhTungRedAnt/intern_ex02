package com.intern.dto.ins;

public class Insurance {
    private String nameInsurance;
    private TypeInsurance typeInsurance;
    private String numberPlate;

    public Insurance(String nameInsurance, TypeInsurance typeInsurance) {
        this.nameInsurance = nameInsurance;
        this.typeInsurance = typeInsurance;
    }

    public String getNameInsurance() {
        return nameInsurance;
    }

    public void setNameInsurance(String nameInsurance) {
        this.nameInsurance = nameInsurance;
    }

    public TypeInsurance getTypeInsurance() {
        return typeInsurance;
    }

    public void setTypeInsurance(TypeInsurance typeInsurance) {
        this.typeInsurance = typeInsurance;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}

package com.intern.main;

import com.intern.dto.car.*;
import com.intern.dto.ins.Insurance;
import com.intern.dto.ins.TypeInsurance;
import com.intern.service.car.AddCarService;
import com.intern.service.car.AddInsuranceService;
import com.intern.service.ins.GetCarService;
import com.intern.service.ins.GetInsuranceService;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainPage();
    }

    private static void mainPage() {
        System.out.println("---------- Menu ----------");
        System.out.println();
        System.out.println(" 1: Create Random 10 Car");
        System.out.println(" 2: Create Random 10 Insurance");
        System.out.println(" 3: Buy Car and Insurance");
        System.out.println(" 4: Show Car");
        System.out.println(" Please select an option!");
        int chose = scanner.nextInt();

        switch (chose) {
            case 1:
                creatRandomCar();
                break;
            case 2:
                createRandomInsurance();
                break;
            case 3:
                manageInsurance();
                break;
            case 4:
                menuCarService();
                break;
            default:
                mainPage();
        }
    }

    private static void creatRandomCar() {
        AddCarService addCarService = new AddCarService();
        Random rd = new Random();

        for (int i = 1; i <= 10; i++) {
            int yearManufacture = addCarService.randomYearManufacture();
            String numberPlate = addCarService.randomNumberPlate();
            String nameCar = addCarService.randomNameCar(i);
            Brand brand = addCarService.randomBrand();
            boolean haveInsurance = addCarService.randomBoolean();

            if (yearManufacture >= 2005) {
                // random havePositioning
                boolean havePositioning = addCarService.randomBoolean();

                ModernCar modernCar = new ModernCar(numberPlate, nameCar, yearManufacture, brand, haveInsurance, havePositioning);
                addCarService.addModernCar(modernCar);
            } else if (yearManufacture <= 1995) {
                // random actionDuration
                int actionDuration = 1 + rd.nextInt(10);

                OldCar oldCar = new OldCar(numberPlate, nameCar, yearManufacture, brand, haveInsurance, actionDuration);
                addCarService.addOldCar(oldCar);
            } else {
                // random havePowerSteering
                boolean havePowerSteering = addCarService.randomBoolean();

                MediumCar mediumCar = new MediumCar(numberPlate, nameCar, yearManufacture, brand, haveInsurance, havePowerSteering);
                addCarService.addMediumCar(mediumCar);
            }
        }

        System.out.println();
        System.out.println(" Create success 10 car");

        mainPage();
    }

    private static void manageInsurance() {
        System.out.println();
        GetInsuranceService showInsService = new GetInsuranceService();
        GetCarService carService = new GetCarService();
        carService.showAllCarByType(null);

        System.out.println();
        System.out.println("Select a Car to Buy by NumberPlate");

        Scanner numberPateScanner = new Scanner(System.in);
        String numberPlate = numberPateScanner.next();
        AddCarService addCarService = new AddCarService();

        if (addCarService.checkHaveInsurance(numberPlate)) {
            // xe da co bao hiem
            System.out.println();
            System.out.println("Unavailable Buying!");
            mainPage();
        } else {
            String typeCar = carService.showTypeCar(numberPlate);
            if (typeCar.equalsIgnoreCase("")) {
                // Kiem tra neu nhap numberPlate khong ton tai
                mainPage();
            }

            showInsService.getInsuranceAvailable();

            System.out.println();
            System.out.println("Please select an Insurance by Name to buy");

            Scanner insScanner = new Scanner(System.in);
            String nameIns = insScanner.nextLine();
            String typeIns = showInsService.getTypeByName(nameIns);
            if (typeIns.equalsIgnoreCase("")) {
                // Kiem tra neu nhap ten Ins sai
                mainPage();
            }

            if ((typeCar.equals(TypeCar.ModernCar.name()) && typeIns.equals(TypeInsurance.A.name()))
                    || (typeCar.equals(TypeCar.MediumCar.name()) && typeIns.equals(TypeInsurance.B.name()))
                    || (typeCar.equals(TypeCar.OldCar.name()) && typeIns.equals(TypeInsurance.C.name()))) {
                System.out.println();
                //update Car and Insurance
                AddInsuranceService addInsService = new AddInsuranceService();
                addCarService.updateHaveInsurance(numberPlate);
                addInsService.buyInsForCar(nameIns, numberPlate);
                System.out.println("Successful Buying");
                mainPage();
            } else {
                System.out.println();
                System.out.println("Invalid Package!");
                mainPage();
            }
        }
    }

    private static void menuCarService() {
        System.out.println(" 1: Show All car");
        System.out.println(" 2: Show Modern car");
        System.out.println(" 3: Show Medium  car");
        System.out.println(" 4: Show Old car");
        GetCarService carService = new GetCarService();
        int chose = scanner.nextInt();

        switch (chose) {
            case 1:
                carService.showAllCarByType(null);
                mainPage();
                break;
            case 2:
                carService.showModernCar();
                mainPage();
                break;
            case 3:
                carService.showMediumCar();
                mainPage();
                break;
            case 4:
                carService.showOldCar();
                mainPage();
                break;
            default:
                mainPage();
        }
    }

    private static void createRandomInsurance() {
        AddInsuranceService addIns = new AddInsuranceService();
        for (int i = 1; i <= 10; i++) {
            String name = addIns.randomNameInsurance(i);
            TypeInsurance type = addIns.randomTypeInsurance();

            Insurance ins = new Insurance(name, type);
            addIns.addIns(ins);
        }

        System.out.println();
        System.out.println(" Create success 10 Insurance");

        mainPage();
    }
}


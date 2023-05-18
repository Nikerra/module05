package org.example;

import java.util.ArrayList;

public class Manager {
    private Warehouse warehouseA = new Warehouse();
    void startWork(){

        System.out.println("Работа по перевозке кусочков счастья начинается");
        System.out.println("На складе находится кусочков счастья в количестве=" + checkPieceLuckWarehouse().size());
        Truck truck = new Truck();
        Driver driver = new Driver();
        Loader loader = new Loader();
        while (checkPieceLuckWarehouse().size() > 0) {
            isFiveDrive(driver);
            loader.workBox(warehouseA, truck, checkPieceLuckWarehouse());
            if (loader.reportLoadTruck(truck)) {
                driver.waitForDownload(true, truck, loader);
            }
        }
        isFinishWork();
    }
    void finishWork(){
        System.out.println("Работа по перевозке кусочков счастья завершена");
        System.out.printf("Было перевезено %d кусочков счастья", warehouseA.getPieceLuckCount());
        System.out.println();
        System.out.printf("Было перевезено %d коробок", new Box().getIdBox());
        System.out.println();
        System.out.printf("Было совершенно всего поездок:%d", new Driver().getCountDrive());
        System.out.println();
        System.out.printf("Было совершенно  поездок на склад В:%d", new Driver().getCountDrive()/2);
        System.out.println();
    }
    ArrayList<PieceLuck> checkPieceLuckWarehouse() {
        return warehouseA.getPieceLucks();
    }

    void isFinishWork() {
        if (checkPieceLuckWarehouse().size() == 0) {
            finishWork();
        }
    }

    /**
     * Проверяем кол-во поездок, если поездка пятая или кратная пяти то увеличиваем кол-во кусочков счастья
     */
    void isFiveDrive(Driver driver){
        if (driver.getCountDrive() % 5 == 0 && driver.getCountDrive() != 0) {
            warehouseA.addPieceLuck(112);
        }
    }

    void startWorkLoader(){}
    void truckFull(){}
    void driveTruck(){}
    void unloadTruck(){}

    void findTruck(){}
    void findLoader(){}
    void findDriver(){}
}


package org.example;

import java.util.ArrayList;

public class Manager {
    private Warehouse warehouseA = new Warehouse();
    void startWork(){

        System.out.println("Работа по перевозке кусочков счастья начинается");
        System.out.println("На складе находится кусочков счастья в количестве=" + resultCheckPieceLuckWarehouse().size());
        Truck truck = new Truck();
        Driver driver = new Driver();
        Loader loader = new Loader();
        while (!resultCheckPieceLuckWarehouse().isEmpty()) {
            isFiveDrive(driver);
            startWorkLoader(loader, truck);

            if (waitForDownload(truck)){
                driver.driveTruck(truck,loader);
            }
        }
        if (isFinishWork()){
            finishWork(driver);
        }
    }

    /**
     *
     */
    boolean waitForDownload(Truck truck) {
        if ((truck.getHowManyBoxesInTruck() == 10) || (truck.getHowManyBoxesInTruck() > 0 && resultCheckPieceLuckWarehouse().isEmpty())) {
            System.out.println("Грузовик загружен");
            return true;
        } else {
            return false;
        }
    }

    void finishWork(Driver driver){
        System.out.println("Работа по перевозке кусочков счастья завершена");
        System.out.printf("Было перевезено %d кусочков счастья", warehouseA.getPieceLuckCount());
        System.out.println();
        System.out.printf("Было перевезено %d коробок", new Box().getIdBox());
        System.out.println();
        System.out.printf("Было совершенно всего поездок:%d", driver.getCountDrive());
        System.out.println();
        System.out.printf("Было совершенно  поездок на склад В:%d", driver.getCountDrive()/2);
        System.out.println();
    }
    ArrayList<PieceLuck> resultCheckPieceLuckWarehouse() {
        return warehouseA.getPieceLucks();
    }

    boolean isFinishWork() {
        return resultCheckPieceLuckWarehouse().isEmpty();
    }

    /**
     * Проверяем кол-во поездок, если поездка пятая или кратная пяти то увеличиваем кол-во кусочков счастья
     */
    void isFiveDrive(Driver driver){
        if (driver.getCountDrive() % 5 == 0 && driver.getCountDrive() != 0) {
            warehouseA.addPieceLuck();
        }
    }

    void startWorkLoader(Loader loader, Truck truck){
        loader.workBox(warehouseA, truck, resultCheckPieceLuckWarehouse());
    }
}

package org.example;

public class Driver {
    private static int countDrive = 0;

    /**
     * @return
     */
    int getCountDrive() {
        return countDrive;
    }

    /**
     * Эмуляция поездки парковки и ожидания разгрузки грузовика
     */
    private void driveTruck(Truck truck, Loader loader) {

        truck.drive();
        parking();
        Driver driver = new Driver();
        waitUnloadTruck(truck, loader, driver);
    }

    /**
     * Эмуляция парковки
     */
    private void parking() {

        System.out.println("Паркуется");
        countDrive++;
    }

    /**
     * @param flag при получении true грузовик загружен и вызываем эмулятор поездки
     */
    void waitForDownload(boolean flag, Truck truck, Loader loader) {

        if (flag) {
            System.out.println("Грузовик загружен");
            driveTruck(truck, loader);
        }
    }

    /**
     * Эмуляция разгрузки грузовика, его обратной поездки парковки и вызова нового цикла его загрузки
     */
    private void waitUnloadTruck(Truck truck, Loader loader, Driver driver) {

        System.out.println("Ждет разгрузки");
        if (!(loader.unloadTruck(truck))) {
            truck.drive();
            parking();
//            loader.workBox(new PieceLuck(), driver, truck);
        }
    }
}
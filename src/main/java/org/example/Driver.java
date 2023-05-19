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
    void driveTruck(Truck truck, Loader loader) {
        truck.drive();
        parking();
        waitUnloadTruck(truck, loader);
    }

    /**
     * Эмуляция парковки
     */
    private void parking() {
        System.out.println("Паркуется");
        countDrive++;
    }

    /**
     * Эмуляция разгрузки грузовика, его обратной поездки парковки и вызова нового цикла его загрузки
     */
    private void waitUnloadTruck(Truck truck, Loader loader) {
        System.out.println("Ждет разгрузки");
        if (!(loader.unloadTruck(truck))) {
            truck.drive();
            parking();
        }
    }
}
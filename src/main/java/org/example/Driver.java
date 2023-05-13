package org.example;

public class Driver {
    private static int countDrive = 0;
    private final Truck truck = new Truck();
    private final Loader loader = new Loader();
    int getCountDrive() {
        return countDrive;
    }

    private void driveTruck(){
        truck.drive();
        parking();
        waitUnloadTruck();
    }
    private void parking(){
        System.out.println("Паркуется");
        countDrive++;
    }
    void waitForDownload(boolean flag){
        if (flag){
            System.out.println("Грузовик загружен");
            driveTruck();
        }
    }
    private void waitUnloadTruck(){
        System.out.println("Ждет разгрузки");
        boolean flag = loader.unloadTruck(true);
        if (!flag) {
            truck.drive();
            parking();
            loader.workBox();
        }
    }
}

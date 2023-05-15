package org.example;

public class Truck {
    private static int howManyBoxesInTruck = 0;
    private final int MAX_CAPACITY_TRUCK = 10;



    int getHowManyBoxesInTruck() {
        return howManyBoxesInTruck;
    }

    void addHowManyBoxesInTruck() {
        howManyBoxesInTruck++;
    }
    void negativeHowManyBoxesInTruck() {
        howManyBoxesInTruck--;
    }

    int getMAX_CAPACITY_TRUCK() {
        return MAX_CAPACITY_TRUCK;
    }

    boolean checkHowManyBoxesInTruck(){
        return howManyBoxesInTruck != MAX_CAPACITY_TRUCK;
    }

    void drive(){
        System.out.println("Грузовик едет со склада на склад");
        for (int i = 0; i < 10; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("Грузовик приехал на склад");
    }
}

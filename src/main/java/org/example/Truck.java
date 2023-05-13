package org.example;

public class Truck {
    void drive(){
        System.out.println("Грузовик едет со склада на склад");
        for (int i = 0; i < 10; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("Грузовик приехал на склад");
    }
}


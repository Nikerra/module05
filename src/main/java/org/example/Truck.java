package org.example;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private static int howManyBoxesInTruck = 0;
    private final int MAX_CAPACITY_TRUCK = 10;
    private static final List<ArrayList<Integer>> boxIntoTruck = new ArrayList<>();


    /**
     * @param i удаляем коробку из грузовика
     */
    void remove(int i){
        boxIntoTruck.remove(i);
    }

    /**
     * @return возвращаем массив в котором лежат наши коробки
     */
    List<ArrayList<Integer>> getBoxIntoTruck() {
        return boxIntoTruck;
    }

    /**
     * @param boxIntoTruck
     * Добавляем наши коробки в грузовик
     */
    void setBoxIntoTruck(ArrayList<Integer> boxIntoTruck) {
        Truck.boxIntoTruck.add(boxIntoTruck);
    }

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

    /**
     * @return проверяем кол-во коробок в грузовике
     * если их меньше чем максимально допустимое кол-во то возвращаем true
     */
    boolean checkHowManyBoxesInTruck(){
        return howManyBoxesInTruck != MAX_CAPACITY_TRUCK;
    }

    /**
     * Эмуляция поездки грузовика
     */
    void drive(){
        System.out.println("Грузовик едет со склада на склад");
        for (int i = 0; i < 10; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("Грузовик приехал на склад");
    }
}
package org.example;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    private static int countBox;

    public  int getCountBox() {
        return countBox;
    }

    /**
     * Метод по загрузке кусочков в коробки и дальнейшей загрузки в грузовик
     * запускаем цикл пока грузовик не будет заполнен
     * проверяем наличие кусочков счастья
     * берем коробку и присваиваем ей новый номер
     * создаем массив коробку и грузим в нее кусочки
     * загружаем кусочки в грузовик
     */
    void workBox(Warehouse warehouseA, Truck truck, ArrayList<PieceLuck> pieceLucks) {

        for (int i = 1; i <= truck.getMAX_CAPACITY_TRUCK(); i++) {
            if (pieceLucks.size() > 0) {
                ++countBox;
                System.out.println("Грузчик берет коробку");
                Box box = new Box(countBox);
                System.out.println("Присваивает коробки новый id:" + box.getIdBox());
                ArrayList<Box> boxPieceLuck = loadIntoBox(warehouseA, box);
                System.out.printf("На складе осталось %d кусочков счастья", warehouseA.getPieceLucksHeap().size());
                System.out.println();
                System.out.println("Коробка № " + box.getIdBox() + " с кусочками счастья:" + boxPieceLuck);
                System.out.println("Идет загружать коробку в грузовик");
                loadIntoTruck(boxPieceLuck, truck);
            }
        }
    }

    /**
     * Принимаем данные о складе и грузим кусочки счастья со склада в коробки
     */
    private ArrayList<Box> loadIntoBox(Warehouse warehouse, Box box) {

        ArrayList<Box> boxPieceLuck = new ArrayList<>();
        if (warehouse.getPieceLucksHeap().size() >= 4) {
            System.out.println("Загружает в нее 4 кусочка счастья");
            for (int i = 0; i < box.getMAX_CAPACITY_BOX(); i++) {
                box.addPieceLuckIntoBox(boxPieceLuck);
                warehouse.removePieceLuckIntoWarehouse();
            }
        } else {
            System.out.printf("Загружает в нее %d кусочка счастья%n", warehouse.getPieceLucksHeap().size());
            while (!warehouse.getPieceLucksHeap().isEmpty()) {
                box.addPieceLuckIntoBox(boxPieceLuck);
                warehouse.removePieceLuckIntoWarehouse();
            }
        }
        return boxPieceLuck;
    }

    /**
     * @param boxPieceLuck принимает массив коробку и грузит его в массив грузовик
     */
    private void loadIntoTruck(ArrayList<Box> boxPieceLuck, Truck truck) {

        if (truck.checkHowManyBoxesInTruck()) {
            truck.addBoxIntoTruck(boxPieceLuck);
            truck.addHowManyBoxesInTruck();
            System.out.printf("Загружено %d из %d коробок", truck.getHowManyBoxesInTruck() , truck.getMAX_CAPACITY_TRUCK());
            System.out.println();
            System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
        }
    }

    /**
     * Если в грузовике 10 коробок или если есть хотя бы одна коробка когда кусочков счастья на складе не осталось
     */
    void reportLoadTruck(Truck truck, Warehouse warehouse) {
        if ((truck.getHowManyBoxesInTruck() == 10) || (truck.getHowManyBoxesInTruck() > 0 && warehouse.getPieceLucksHeap().isEmpty())) {
            System.out.println("Грузовик загружен");
        }
    }

    /**
     * Разгружаем коробки пока грузовик не будет пуст
     * после чего @return true
     */
    boolean unloadTruck(Truck truck) {

        System.out.println("Начинается разгрузка грузовика");
        System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
        int boxUnloadTruckCount = 0;
        while (true) {
            if (truck.getHowManyBoxesInTruck() > 0) {
                System.out.printf("Разгружено %d из %d коробок", (boxUnloadTruckCount+1), truck.getMAX_CAPACITY_TRUCK());
                truck.remove(truck.getBoxIntoTruck().size() - 1);
                truck.substractHowManyBoxesInTruck();
                System.out.println();
                System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
            } else {
                System.out.println("Разгрузка грузовика окончена");
                return true;
            }
            boxUnloadTruckCount++;
        }
    }
}


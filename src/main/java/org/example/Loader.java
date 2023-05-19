package org.example;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static final Box box = new Box();

    /**
     * Старт работы грузчика
     * проверяет кол-во поездок(каждую пятую добавить на склад кусочков счастья)
     * проверяет кол-во кусочков(если их нет то завершает работу иначе
     * берет коробку грузит в нее максимально допустимое кол-во
     * и грузит коробку в грузовик)
     * Сообщает водителю, что можно ехать
     */
    void workBox(Warehouse warehouseA, Truck truck, ArrayList<PieceLuck> pieceLucks) {

        for (int countBox = 1; countBox <= truck.getMAX_CAPACITY_TRUCK(); countBox++) {
            if (pieceLucks.size() > 0) {
                System.out.println("Грузчик берет коробку");
                box.setIdBox();
                System.out.println("Присваивает коробки новый id:" + box.getIdBox());
                ArrayList<PieceLuck> boxPieceLuck = loadIntoBox(warehouseA);
                if (boxPieceLuck != null) {
                    System.out.println("Идет загружать коробку в грузовик");
                    loadIntoTruck(boxPieceLuck, truck);
                }
            }
        }
    }

    /**
     * @param boxPieceLuck грузит в коробку
     * @return коробку - массив
     */
    private ArrayList<PieceLuck> loadIntoBox(Warehouse warehouse) {

        ArrayList<PieceLuck> boxPieceLuck = new ArrayList<>();
        if (warehouse.getPieceLucks().size() >= 4) {
            System.out.println("Загружает в нее 4 кусочка счастья");
            for (int i = 0; i < box.getMAX_CAPACITY_BOX(); i++) {
                boxPieceLuck.add(warehouse.getPieceLucks().get(0));
                warehouse.getPieceLucks().remove(0);
                warehouse.setPieceLuckCount();
            }
        } else {
            System.out.printf("Загружает в нее %d кусочка счастья%n", warehouse.getPieceLucks().size());
            while (!warehouse.getPieceLucks().isEmpty()) {
                boxPieceLuck.add(warehouse.getPieceLucks().get(0));
                warehouse.getPieceLucks().remove(0);
                warehouse.setPieceLuckCount();
            }
        }
        System.out.println("Коробка № " + box.getIdBox() + " с кусочками счастья:" + boxPieceLuck);
        System.out.printf("На складе осталось %d кусочков счастья", warehouse.getPieceLucks().size());
        System.out.println();
        return boxPieceLuck;
    }

    /**
     * @param boxPieceLuck принимает массив коробку и грузит его в массив грузовик
     */
    private void loadIntoTruck(ArrayList<PieceLuck> boxPieceLuck, Truck truck) {

        if (truck.checkHowManyBoxesInTruck()) {
            truck.setBoxIntoTruck(boxPieceLuck);
            truck.addHowManyBoxesInTruck();
            System.out.printf("Загружено %d из %d коробок", truck.getHowManyBoxesInTruck() , truck.getMAX_CAPACITY_TRUCK());
            System.out.println();
            System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
        }
    }

    /**
     * @return true если в грузовике есть хоть одна коробка
     */
    boolean reportLoadTruck(Truck truck) {
        return  truck.getHowManyBoxesInTruck() > 0;
    }

    /**
     * Разгружаем коробки пока грузовик не будет пуст
     * после чего @return flag установленный в false
     */
    boolean unloadTruck(Truck truck) {

        System.out.println("Начинается разгрузка грузовика");
        System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
        int boxUnloadTruckCount = 0;
        while (true) {
            if (truck.getHowManyBoxesInTruck() > 0) {
                System.out.printf("Разгружено %d из %d коробок", (boxUnloadTruckCount+1), truck.getMAX_CAPACITY_TRUCK());
                truck.remove(truck.getBoxIntoTruck().size() - 1);
                truck.negativeHowManyBoxesInTruck();
                System.out.println();
                System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
            } else {
                System.out.println("Разгрузка грузовика окончена");
                return false;
            }
            boxUnloadTruckCount++;
        }
    }
}


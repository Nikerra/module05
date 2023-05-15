package org.example;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static final Box box = new Box();
    private static final Warehouse warehouse = new Warehouse();

    /**
     * Старт работы грузчика
     * проверяет кол-во поездок(каждую пятую добавить на склад кусочков счастья)
     * проверяет кол-во кусочков(если их нет то завершает работу иначе
     * берет коробку грузит в нее максимально допустимое кол-во
     * и грузит коробку в грузовик)
     * Сообщает водителю, что можно ехать
     */
    void workBox(PieceLuck pieceLuck, Driver driver, Truck truck) {
        Loader loader = new Loader();
        driver.isFiveDrive(warehouse, pieceLuck);
        warehouse.isFinishWork(pieceLuck);

        for (int countBox = 1; countBox <= truck.getMAX_CAPACITY_TRUCK(); countBox++) {
            List<Integer> boxPieceLuckLocal = new ArrayList<>(4);
            if (pieceLuck.getPieceLuck() > 0) {
                System.out.println("Грузчик берет коробку");
                box.setIdBox();
                System.out.println("Присваивает коробки новый id:" + box.getIdBox());
                ArrayList<Integer> boxPieceLuck = loadIntoBox(boxPieceLuckLocal, pieceLuck);
                if (boxPieceLuck != null) {
                    System.out.println("Идет загружать коробку в грузовик");
                    loadIntoTruck(boxPieceLuck, truck);
                }
            }
        }
        driver.waitForDownload(reportLoadTruck(truck), truck, loader);
    }

    /**
     * @param boxPieceLuck грузит в коробку
     * @return коробку - массив
     */
    private ArrayList<Integer> loadIntoBox(List<Integer> boxPieceLuck, PieceLuck pieceLuck) {
        int pieceLuckCountLocal = 0;
        if (pieceLuck.getPieceLuck() >= 4) {
            System.out.println("Загружает в нее 4 кусочка счастья");
            for (int i = 1; i <= box.getMAX_CAPACITY_BOX(); i++) {
//                System.out.println("Загружено кусочек счастья номер:" + i);
                boxPieceLuck.add(i);
                warehouse.setPieceLuckCount();
                pieceLuckCountLocal++;
            }
        } else {
            boxPieceLuck = new ArrayList<>(pieceLuck.getPieceLuck());
            System.out.printf("Загружает в нее %d кусочка счастья%n", pieceLuck.getPieceLuck());
            for (int i = 1; i <= pieceLuck.getPieceLuck(); i++) {
//                System.out.println("Загружено кусочек счастья номер:" + i);
                boxPieceLuck.add(i);
                warehouse.setPieceLuckCount();
                pieceLuckCountLocal++;
            }
        }
        System.out.println(boxPieceLuck);
        warehouse.negativePieceLuck(pieceLuckCountLocal, pieceLuck);
        System.out.printf("На складе осталось %d кусочков счастья", pieceLuck.getPieceLuck());
        System.out.println();
        return (ArrayList<Integer>) boxPieceLuck;
    }

    /**
     * @param boxPieceLuck принимает массив коробку и грузит его в массив грузовик
     */
    private void loadIntoTruck(ArrayList<Integer> boxPieceLuck, Truck truck) {

        if (truck.checkHowManyBoxesInTruck()) {
            truck.setBoxIntoTruck(boxPieceLuck);
            truck.addHowManyBoxesInTruck();
            System.out.printf("Загруженно %d из %d коробок", truck.getHowManyBoxesInTruck() , truck.getMAX_CAPACITY_TRUCK());
            System.out.println();
            System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
        }
    }

    /**
     * @return true если в грузовике есть хоть одна коробка
     */
    private boolean reportLoadTruck(Truck truck) {
        return  truck.getHowManyBoxesInTruck() > 0;
    }

    /**
     * @param flag разгружаем коробки пока грузовик не будет пуст
     * после чего @return flag установленный в false
     */
    boolean unloadTruck(boolean flag, Truck truck) {
        System.out.println("Начинается разгрузка грузовика");
        System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
        int boxUnloadTruckCount = 0;
        while (flag) {
            if (truck.getHowManyBoxesInTruck() > 0) {
                System.out.printf("Разгружено %d из %d коробок", (boxUnloadTruckCount+1), truck.getMAX_CAPACITY_TRUCK());
                truck.remove(truck.getBoxIntoTruck().size() - 1);
                truck.negativeHowManyBoxesInTruck();
                System.out.println();
                System.out.println("Коробки в грузовике:" + truck.getBoxIntoTruck());
            } else {
                System.out.println("Разгрузка грузовика окончена");
                flag = false;
            }
            boxUnloadTruckCount++;
        }
        return flag;
    }
}


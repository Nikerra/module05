package org.example;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static final Box box = new Box();
    private Truck truck = new Truck();
    private final PieceLuck pieceLuck = new PieceLuck();
    boolean reportLoadTruckFlag = false;
    private static List<ArrayList<Integer>> boxIntoTruck = new ArrayList<>();


    void workBox() {
        Driver driver = new Driver();
        if (driver.getCountDrive() % 5 == 0 && driver.getCountDrive() !=0) {
            pieceLuck.addPieceLuck();
        }
        if (pieceLuck.getPieceLuck() == 0) {
            new Warehouse().finishWork();
        }
        for (int countBox = 1; countBox <= truck.getMAX_CAPACITY_TRUCK(); countBox++) {
            List<Integer> boxPieceLuckLocal = new ArrayList<>(4);
            if (pieceLuck.getPieceLuck() > 0) {
                System.out.println("Грузчик берет коробку");
                box.setIdBox();
                System.out.println("Присваивает коробки новый id:" + box.getIdBox());
                ArrayList<Integer> boxPieceLuck = loadIntoBox(boxPieceLuckLocal);
                if (boxPieceLuck != null) {
                    System.out.println("Идет загружать коробку в грузовик");
                    loadIntoTruck(boxPieceLuck);
                }
            }
        }
        if (reportLoadTruck()) {
            driver.waitForDownload(reportLoadTruckFlag);
        }
    }

    private ArrayList<Integer> loadIntoBox(List<Integer> boxPieceLuck) {
        int pieceLuckCountLocal = 0;
        if (pieceLuck.getPieceLuck() >= 4) {
            System.out.println("Загружает в нее 4 кусочка счастья");
            for (int i = 1; i <= box.getMAX_CAPACITY_BOX(); i++) {
//                System.out.println("Загружено кусочек счастья номер:" + i);
                boxPieceLuck.add(i);
                pieceLuck.setPieceLuckCount();
                pieceLuckCountLocal++;
            }
        } else {
            boxPieceLuck = new ArrayList<>(pieceLuck.getPieceLuck());
            System.out.printf("Загружает в нее %d кусочка счастья%n", pieceLuck.getPieceLuck());
            for (int i = 1; i <= pieceLuck.getPieceLuck(); i++) {
//                System.out.println("Загружено кусочек счастья номер:" + i);
                boxPieceLuck.add(i);
                pieceLuck.setPieceLuckCount();
                pieceLuckCountLocal++;
            }
        }
        System.out.println(boxPieceLuck);
        pieceLuck.negativePieceLuck(pieceLuckCountLocal);
        System.out.printf("На складе осталось %d кусочков счастья", pieceLuck.getPieceLuck());
        System.out.println();
        return (ArrayList<Integer>) boxPieceLuck;
    }

    private void loadIntoTruck(ArrayList<Integer> boxPieceLuck) {

        if (truck.checkHowManyBoxesInTruck()) {
            boxIntoTruck.add(boxPieceLuck);
            truck.addHowManyBoxesInTruck();
            System.out.printf("Загруженно %d из %d коробок", truck.getHowManyBoxesInTruck() , truck.getMAX_CAPACITY_TRUCK());
            System.out.println();
            System.out.println("Коробки в грузовике:" + boxIntoTruck);
        }
    }

    private boolean reportLoadTruck() {
        if (truck.getHowManyBoxesInTruck() != 0) {
            return reportLoadTruckFlag = true;
        } else {
            return reportLoadTruckFlag;
        }
    }

    boolean unloadTruck(boolean flag) {
        System.out.println("Начинается разгрузка грузовика");
        System.out.println("Коробки в грузовике:" + boxIntoTruck);
        int i = 0;
        while (flag) {
            int boxUnloadTruckCount = 0;
            if (truck.getHowManyBoxesInTruck() > 0) {
                System.out.printf("Разгружено %d из %d коробок", (i+1), truck.getMAX_CAPACITY_TRUCK());
                boxIntoTruck.remove(boxUnloadTruckCount);
                boxUnloadTruckCount--;
                truck.negativeHowManyBoxesInTruck();
                System.out.println();
                System.out.println("Коробки в грузовике" + boxIntoTruck);
            } else {
                System.out.println("Разгрузка грузовика окончена");
                flag = false;
            }
            i++;
        }
        boxIntoTruck = new ArrayList<>();
        return flag;
    }
}

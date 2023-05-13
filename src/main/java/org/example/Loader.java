package org.example;

public class Loader {
    private static final Box box = new Box();
    private final int[] MAX_CAPACITY_TRUCK = new int[10];
    private static int howManyBoxesInTruck = 0;
    boolean reportLoadTruckFlag = false;
    private static int idBox = box.getIdBox();
    private final PieceLuck pieceLuck = new PieceLuck();


    public int getIdBox() {
        return idBox;
    }

    void workBox() {
        Driver driver = new Driver();
        if (driver.getCountDrive() % 5 == 0){
            pieceLuck.addPieceLuck();
        }
        if (pieceLuck.getPieceLuck() == 0) {
            new Warehouse().finishWork();
        }
        int countBox = 1;
        for (; countBox <= MAX_CAPACITY_TRUCK.length; countBox++) {
            if (pieceLuck.getPieceLuck() > 0) {
                System.out.println("Грузчик берет коробку");
                box.setIdBox(++idBox);
                System.out.println("Присваевает коробки новый id:" + box.getIdBox());
                loadIntoBox();
                if (box != null && pieceLuck.getPieceLuck() > 0) {
                    System.out.println("Идет загружать коробку в грузовик");
                    loadIntoTruck();
                }
            }
        }
        if (reportLoadTruck()) {
            driver.waitForDownload(reportLoadTruckFlag);
        }
    }

    private Box loadIntoBox() {
        int pieceLuckCount = 0;
        if (pieceLuck.getPieceLuck() >= 4) {
            System.out.println("Загружает в нее 4 кусочка счастья");
            int MAX_CAPACITY_BOX = 4;
            for (int i = 1; i <= MAX_CAPACITY_BOX; i++) {
                System.out.println("Загружено кусочек счастья номер:" + i);
                pieceLuckCount++;
            }
        } else {
            System.out.printf("Загружает в нее %d кусочка счастья%n", pieceLuck.getPieceLuck());
            for (int i = 1; i <= pieceLuck.getPieceLuck(); i++) {
                System.out.println("Загружено кусочек счастья номер:" + i);
                pieceLuckCount++;
            }
        }
        pieceLuck.negativePieceLuck(pieceLuckCount);
        System.out.printf("На складе осталось %d кусочков счастья", pieceLuck.getPieceLuck());
        System.out.println();
        return box;
    }

    private void loadIntoTruck() {
        if (howManyBoxesInTruck != MAX_CAPACITY_TRUCK.length) {
            System.out.printf("Загруженно %d/%d коробок", ++howManyBoxesInTruck, MAX_CAPACITY_TRUCK.length);
            System.out.println();
        }
    }

    private boolean reportLoadTruck() {
        if (howManyBoxesInTruck != 0) {
            return reportLoadTruckFlag = true;
        } else {
            return reportLoadTruckFlag;
        }
    }

    boolean unloadTruck(boolean flag) {
        System.out.println("Начинается разгрузка грузовика");
        while (flag) {
            if (howManyBoxesInTruck > 0) {
                System.out.printf("Разгруженно %d коробок", howManyBoxesInTruck--);
                System.out.println();
            } else {
                System.out.println("Разгрузка грузовика окончена");
                flag = false;
            }
        }
        return flag;
    }
}

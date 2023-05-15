package org.example;

public class Driver {
    private static int countDrive = 0;


    /**
     * Проверяем кол-во поездок, если поездка пятая или кратная пяти то увеличиваем кол-во кусочков счастья
     */
    void isFiveDrive(){
        if (getCountDrive() % 5 == 0 && getCountDrive() != 0) {
            new PieceLuck().addPieceLuck();
        }
    }


    /**
     * @return
     */
    int getCountDrive() {
        return countDrive;
    }

    /**
     * Эмуляция поездки парковки и ожидания разгрузки грузовика
     */
    private void driveTruck(){
        new Truck().drive();
        parking();
        waitUnloadTruck();
    }

    /**
     * Эмуляция парковки
     */
    private void parking(){
        System.out.println("Паркуется");
        countDrive++;
    }

    /**
     * @param flag при получении true грузовик загружен и вызываем эмулятор поездки
     */
    void waitForDownload(boolean flag){
        if (flag){
            System.out.println("Грузовик загружен");
            driveTruck();
        }
    }

    /**
     * Эмуляция разгрузки грузовика, его обратной поездки парковки и вызова нового цикла его загрузки
     */
    private void waitUnloadTruck(){
        System.out.println("Ждет разгрузки");
        boolean flag = new Loader().unloadTruck(true);
        if (!flag) {
            new Truck().drive();
            parking();
            new Loader().workBox();
        }
    }
}
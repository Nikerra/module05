package org.example;

import java.util.ArrayList;

public class Warehouse {
    private static int pieceLuckCount = 0;
    private  static ArrayList<PieceLuck> pieceLucks = new ArrayList<>();

    static {
        for (int i = 0; i < new PieceLuck().getPieceLuck(); i++){
            pieceLucks.add(new PieceLuck());
        }
    }


    public  ArrayList<PieceLuck> getPieceLucks() {
        return pieceLucks;
    }

    void setPieceLuckCount() {
        pieceLuckCount++;
    }
    protected int getPieceLuckCount() {return pieceLuckCount;}

    /**
     * каждую 5ю поездку добавляем кусочки счастья
     */
    void addPieceLuck(int pieceLuck) {
        for (int i = 0; i < pieceLuck; i++) {
            pieceLucks.add(new PieceLuck());
        }
    }
//    public static void setPieceLucks(ArrayList<PieceLuck> pieceLucks) {
//        Warehouse.pieceLucks = pieceLucks;
//    }

//    /**
//     *  Краткое описание начала работы
//     */
////    void startWork(PieceLuck pieceLuck){
////        System.out.println("Работа по перевозке кусочков счастья начинается");
////        System.out.println("На складе находится кусочков счастья в количестве=" + getPieceLucks().size());
////        Driver driver = new Driver();
////        Truck truck = new Truck();
////        new Loader().workBox(pieceLuck, driver, truck);
////    }
//
//    /**
//     * Тестовый вывод результатов работы
//     */
//    void finishWork(Driver driver, Box box){
//        System.out.println("Работа по перевозке кусочков счастья завершена");
//        System.out.printf("Было перевезено %d кусочков счастья", getPieceLuckCount());
//        System.out.println();
//        System.out.printf("Было перевезено %d коробок", box.getIdBox());
//        System.out.println();
//        System.out.printf("Было совершенно всего поездок:%d", driver.getCountDrive());
//        System.out.println();
//        System.out.printf("Было совершенно  поездок на склад В:%d", driver.getCountDrive()/2);
//        System.out.println();
//        System.out.println(pieceLucks.size());
//    }
//
//    /**
//     * Проверка наличия кусочков счастья на складе, если их нет то вызываем метод завершения работы
//     */
//    void isFinishWork(PieceLuck pieceLuck, Driver driver, Box box) {
//        if (pieceLuck.getPieceLuck() == 0) {
////            finishWork(driver, box);
//        }
//    }
    //    /**
//     *
//     * Уменьшаем кол-во кусочков счастья
//     */
//    void substractPieceLuck(int pieceLuckCount, PieceLuck pieceLuck) {
//        int value = pieceLuck.getPieceLuck();
//        value -= pieceLuckCount;
//        pieceLuck.setPieceLuck(value);
//    }

}
package org.example;

public class Warehouse {
    void startWork(){
        PieceLuck pieceLuck = new PieceLuck();
        System.out.println("Работа по перевозке кусочков счастья начинается");
        System.out.println("На складе находится кусочков счастья в количестве=" + pieceLuck.getPieceLuck());
        Loader loader = new Loader();
        loader.workBox();
    }
    void finishWork(){
        System.out.println("Работа по перевозке кусочков счастья завершена");
        System.out.printf("Было перевезено %d коробок", new Loader().getIdBox());
        System.out.println();
        System.out.printf("Было совершенно всего поездок:%d", new Driver().getCountDrive());
        System.out.println();
        System.out.printf("Было совершенно  поездок на склад В:%d", new Driver().getCountDrive()/2);
    }
}

package org.example;

public class Warehouse {
    /**
     *  Краткое описание начала работы
     */
    void startWork(){
        System.out.println("Работа по перевозке кусочков счастья начинается");
        System.out.println("На складе находится кусочков счастья в количестве=" + new PieceLuck().getPieceLuck());
        new Loader().workBox();
    }

    /**
     * Тестовый вывод результатов работы
     */
    void finishWork(){
        System.out.println("Работа по перевозке кусочков счастья завершена");
        System.out.printf("Было перевезено %d кусочков счастья", new PieceLuck().getPieceLuckCount());
        System.out.println();
        System.out.printf("Было перевезено %d коробок", new Box().getIdBox());
        System.out.println();
        System.out.printf("Было совершенно всего поездок:%d", new Driver().getCountDrive());
        System.out.println();
        System.out.printf("Было совершенно  поездок на склад В:%d", new Driver().getCountDrive()/2);
        System.out.println();
    }

    /**
     * Проверка наличия кусочков счастья на складе, если их нет то вызываем метод завершения работы
     */
    void isFinishWork() {
        if (new PieceLuck().getPieceLuck() == 0) {
            finishWork();
        }
    }

}
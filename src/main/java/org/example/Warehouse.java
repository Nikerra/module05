package org.example;

public class Warehouse {
    private static int pieceLuckCount = 0;


    /**
     *  Краткое описание начала работы
     */
    void startWork(PieceLuck pieceLuck){
        System.out.println("Работа по перевозке кусочков счастья начинается");
        System.out.println("На складе находится кусочков счастья в количестве=" + pieceLuck.getPieceLuck());
        Driver driver = new Driver();
        Truck truck = new Truck();
        new Loader().workBox(pieceLuck, driver, truck);
    }

    /**
     * Тестовый вывод результатов работы
     */
    void finishWork(){
        System.out.println("Работа по перевозке кусочков счастья завершена");
        System.out.printf("Было перевезено %d кусочков счастья", getPieceLuckCount());
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
    void isFinishWork(PieceLuck pieceLuck) {
        if (pieceLuck.getPieceLuck() == 0) {
            finishWork();
        }
    }

    void setPieceLuckCount() {
        pieceLuckCount++;
    }
    private int getPieceLuckCount() {return pieceLuckCount;}


    /**
     * @param
     * уменьшаем кол-во кусочков счастья
     */
    void negativePieceLuck(int pieceLuckCount, PieceLuck pieceLuck) {
        int value = pieceLuck.getPieceLuck();
        value -= pieceLuckCount;
        pieceLuck.setPieceLuck(value);
    }

    /**
     * каждую 5ю поездку добавляем кусочки счастья
     */
    void positivePieceLuck(PieceLuck pieceLuck) {
        int value = pieceLuck.getPieceLuck();
        value += 112;
        pieceLuck.setPieceLuck(value);
    }

}
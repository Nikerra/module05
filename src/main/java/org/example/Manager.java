package org.example;

import java.util.ArrayList;

public class Manager {
    private final Warehouse warehouseA = new Warehouse();

    /**
     * Менеджер начинает работу и указывает сколько у нас на старте кусочков счастья для перевозки
     * находит(создает) грузовик, водителя и грузчика
     * запускаем цикл по перевозке и ждем когда на складе не останется кусочков счастья
     * узнаем у водителя какая по счету поездка методом isFiveDriver
     * даем команду грузчику на работу
     * ожидаем пока грузовик будет загружен
     * отправляем водителя с грузчиком на второй склад для разгрузки
     * проверяем сколько кусочков счастья если больше нуля повторяем цикл
     * иначе завершаем работу
     */
    public void startWork(){

        System.out.println("Работа по перевозке кусочков счастья начинается");
        System.out.println("На складе находится кусочков счастья в количестве=" + resultCheckPieceLuckWarehouse().size());
        Truck truck = new Truck();
        Driver driver = new Driver();
        Loader loader = new Loader();
        while (!resultCheckPieceLuckWarehouse().isEmpty()) {
            isFiveDrive(driver);
            startWorkLoader(loader, truck);
            waitForDownload(truck, warehouseA, loader);
            driver.driveTruck(truck,loader);
        }
        if (isFinishWork()){
            finishWork(driver, loader);
        }
    }

    /**
     * Передаем три параметра грузчика, склад и грузовик
     * для запуска метода грузчика отчет о загрузке грузовика
     * в который передаем параметры грузовика и склада
     */
    void waitForDownload(Truck truck, Warehouse warehouse, Loader loader) {
        loader.reportLoadTruck(truck, warehouse);
    }

    /**
     * Выводим в консоль данные о проведенной работе
     */
    void finishWork(Driver driver, Loader loader){
        System.out.println("Работа по перевозке кусочков счастья завершена");
        System.out.printf("Было перевезено %d кусочков счастья", warehouseA.getPieceLuckCount());
        System.out.println();
        System.out.printf("Было перевезено %d коробок", loader.getCountBox());
        System.out.println();
        System.out.printf("Было совершенно всего поездок:%d", driver.getCountDrive());
        System.out.println();
        System.out.printf("Было совершенно  поездок на склад В:%d", driver.getCountDrive()/2);
        System.out.println();
    }
    private ArrayList<PieceLuck> resultCheckPieceLuckWarehouse() {
        return warehouseA.getPieceLucksHeap();
    }

    /**
     * @return возвращаем true когда кусочков счастья не осталось на складе
     */
    private boolean isFinishWork() {
        return resultCheckPieceLuckWarehouse().isEmpty();
    }

    /**
     * Проверяем кол-во поездок, если поездка пятая или кратная пяти то увеличиваем кол-во кусочков счастья
     */
    void isFiveDrive(Driver driver){
        if (driver.getCountDrive() % 5 == 0 && driver.getCountDrive() != 0) {
            warehouseA.addPieceLuck();
        }
    }

    /**
     * @param loader
     * @param truck
     * Запуск работы грузчика, передаем методу данные про грузчика, грузовик и результат подсчета кол-ва
     * наших кусочков счастья оставшихся для загрузки
     */
    void startWorkLoader(Loader loader, Truck truck){
        loader.workBox(warehouseA, truck, resultCheckPieceLuckWarehouse());
    }
}

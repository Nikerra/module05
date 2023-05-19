package org.example;

import java.util.ArrayList;

public class Warehouse {
    private static int pieceLuckCount = 0;
    private  static final ArrayList<PieceLuck> pieceLucks = new ArrayList<>();

    /**
     * Создаем массив содержащий ноши кусочки в массиве
     */
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
    void addPieceLuck() {
        for (int i = 0; i < 112; i++) {
            pieceLucks.add(new PieceLuck());
        }
    }
}
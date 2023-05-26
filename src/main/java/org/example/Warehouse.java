package org.example;

import java.util.ArrayList;

public class Warehouse {
    private static int pieceLuckCount = 0;
    private  static  ArrayList<PieceLuck> pieceLucksHeap;

    public Warehouse(ArrayList<PieceLuck> pieceLucksHeap) {
        Warehouse.pieceLucksHeap = pieceLucksHeap;
    }



    public  ArrayList<PieceLuck> getPieceLucksHeap() {
        return pieceLucksHeap;
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
            pieceLucksHeap.add(new PieceLuck());
        }
    }

    public void removePieceLuckIntoWarehouse() {
        getPieceLucksHeap().remove(0);
        setPieceLuckCount();
    }
}
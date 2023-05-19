package org.example;

import java.util.ArrayList;

public class Box {
    private int id;

    public Box(int countBox) {
        id = countBox;
    }

    public Box() {
    }

    /**
     * @return id - box
     */
    int getIdBox() {
        return id;
    }


    /**
     * @return size box
     */
    int getMAX_CAPACITY_BOX() {
        return 4;
    }

    ArrayList<Box> loadIntoBox(Warehouse warehouse) {

        ArrayList<Box> boxPieceLuck = new ArrayList<>();
        if (warehouse.getPieceLucksHeap().size() >= 4) {
            System.out.println("Загружает в нее 4 кусочка счастья");
            for (int i = 0; i < getMAX_CAPACITY_BOX(); i++) {
                boxPieceLuck.add(warehouse.getPieceLucksHeap().get(0));
                warehouse.getPieceLucksHeap().remove(0);
                warehouse.setPieceLuckCount();
            }
        } else {
            System.out.printf("Загружает в нее %d кусочка счастья%n", warehouse.getPieceLucksHeap().size());
            while (!warehouse.getPieceLucksHeap().isEmpty()) {
                boxPieceLuck.add(warehouse.getPieceLucksHeap().get(0));
                warehouse.getPieceLucksHeap().remove(0);
                warehouse.setPieceLuckCount();
            }
        }
        System.out.println("Коробка № " + getIdBox() + " с кусочками счастья:" + boxPieceLuck);
        System.out.printf("На складе осталось %d кусочков счастья", warehouse.getPieceLucksHeap().size());
        System.out.println();
        return boxPieceLuck;
    }
}
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

    public ArrayList<Box> addPieceLuckIntoBox(ArrayList<Box> boxPieceLuck) {
        boxPieceLuck.add(new PieceLuck());
        return boxPieceLuck;
    }
}
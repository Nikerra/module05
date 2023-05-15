package org.example;

public class Box {
    private static int id;
    private static final int MAX_CAPACITY_BOX = 4;

    int getIdBox() {
        return id;
    }

    void setIdBox() {
        id++;
    }

    public int getMAX_CAPACITY_BOX() {
        return MAX_CAPACITY_BOX;
    }
}

package org.example;

public class Box {
    private static int id;
    private final int MAX_CAPACITY_BOX = 4;

    /**
     * @return id - box
     */
    int getIdBox() {
        return id;
    }

    /**
     * setup id - box
     */
    void setIdBox() {
        id++;
    }

    /**
     * @return size box
     */
    int getMAX_CAPACITY_BOX() {
        return MAX_CAPACITY_BOX;
    }
}
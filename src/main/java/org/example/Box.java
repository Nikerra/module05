package org.example;

public class Box {
    private static int id;

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
        return 4;
    }
}
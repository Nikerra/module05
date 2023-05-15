package org.example;

public class PieceLuck {
    public static int pieceLuck;


    public PieceLuck() {}

    public PieceLuck(int pieceLuck) {
        PieceLuck.pieceLuck = pieceLuck;
    }

    public int getPieceLuck() {
        return pieceLuck;
    }

    public  void setPieceLuck(int pieceLuck) {
        PieceLuck.pieceLuck = pieceLuck;
    }
}


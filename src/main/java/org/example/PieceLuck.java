package org.example;

public class PieceLuck {
    public static int pieceLuck;

    @Override
    public String toString() {
        return "PieceLuck";
    }

    public PieceLuck() {}

    public PieceLuck(int pieceLuck) {
        PieceLuck.pieceLuck = pieceLuck;
    }

    public int getPieceLuck() {
        return pieceLuck;
    }
}


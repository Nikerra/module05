package org.example;

public class PieceLuck extends Box {
    public static int pieceLuck;

    public PieceLuck() {
    }

    public PieceLuck(int i) {
        pieceLuck = i;
    }

    @Override
    public String toString() {
        return "PieceLuck";
    }

    public int getPieceLuck() {
        return pieceLuck;
    }
}


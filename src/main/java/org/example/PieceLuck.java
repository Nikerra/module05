package org.example;

public class PieceLuck extends Box {
    public static int pieceLuck = 10_591;

    @Override
    public String toString() {
        return "PieceLuck";
    }

    public PieceLuck() {}

    public int getPieceLuck() {
        return pieceLuck;
    }
}


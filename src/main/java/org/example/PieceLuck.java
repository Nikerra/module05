package org.example;

public class PieceLuck {
    private static int pieceLuck = 10_591;
    private static int pieceLuckCount = 0;

    void setPieceLuckCount() {
        PieceLuck.pieceLuckCount++;
    }
    int getPieceLuckCount() {return pieceLuckCount;}

    int getPieceLuck() {
        return pieceLuck;
    }

    void negativePieceLuck(int pieceLuck) {
        PieceLuck.pieceLuck -= pieceLuck;
    }
    void addPieceLuck() {
        PieceLuck.pieceLuck += 112;
    }
}


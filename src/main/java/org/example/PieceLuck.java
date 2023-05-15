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

    /**
     * @param pieceLuck
     * уменьшаем кол-во кусочков счастья
     */
    void negativePieceLuck(int pieceLuck) {
        PieceLuck.pieceLuck -= pieceLuck;
    }

    /**
     * каждую 5ю поездку добавляем кусочки счастья
     */
    void addPieceLuck() {
        pieceLuck += 112;
    }
}


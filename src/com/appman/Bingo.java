package com.appman;

public class Bingo {

    public static final int WIN = 5;

    public String getBingo(int inputs[]){
        int winX = 0;
        int winY = 0;
        int[][] board = new InitBoard().invoke();
        for (int i =0; i<board.length;i++){
            winY = getWinY(inputs, winY, board, i);
            winX = getWinX(inputs, winX, board, board[i]);
            if (winX == WIN || winY == WIN) return "Bingo";
            winY =0;
            winX =0;
        }
        return "Not Bingo";
    }

    private int getWinY(int[] inputs, int winY, int[][] board, int i) {
        for (int j = 0; j < board.length; j++) {
            for (int input : inputs){
                if (board[j][i] == input) winY++;
            }
        }
        return winY;
    }

    private int getWinX(int[] inputs, int winX, int[][] board, int[] ints) {
        for (int j = 0; j < board.length; j++) {
            for (int input : inputs){
                if (ints[j] == input) winX++;
            }
        }
        return winX;
    }

    private class InitBoard {
        public int[][] invoke() {
            return new int[][]{
                        {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}
                };
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] input  = {3, 4, 8, 13, 18, 19, 23};
        System.out.println(new Bingo().getBingo(input));

        input = new int[]{1, 13, 19, 25, 23, 2};
        System.out.println(new Bingo().getBingo(input));

        input = new int[]{2, 1, 12, 15, 6, 18, 16, 4, 3, 21, 11};
        System.out.println(new Bingo().getBingo(input));

    }
}

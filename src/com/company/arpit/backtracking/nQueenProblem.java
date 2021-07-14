package com.company.arpit.backtracking;

/*Given n*n board ,n queens need to be placed on that board so that they do not collide
 * Collision : not in same row,not in same column , not diagonally
 * */
public class nQueenProblem {


    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        boolean result = nQueen(board, 0);
        System.out.println(result);


    }

    private static boolean nQueen(int[][] board, int row) {
        if (row >= board.length) {
            printBoard(board);
            return true;
        }

        for (int c = 0; c < board[0].length; c++) {
            if (isSafe(board, row, c)) {
                board[row][c] = 1;
                if (nQueen(board, row + 1)) {
                    return true;
                }
              //  board[row][c] = 0;
            }
        }
        return false;


    }

    private static void printBoard(int[][] board) {

        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[0].length;c++)
            {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }


    }

    private static boolean isSafe(int[][] board, int row, int column) {
        //check row above
        for (int r = row; r >= 0; r--) {
            if (board[r][column] == 1)
                return false;
        }


        //check diagonal left top
        for (int r = row, c = column; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 1)
                return false;
        }
        //check diagonal right top
        for (int r = row, c = column; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c] == 1)
                return false;
        }

        return true;

    }


}

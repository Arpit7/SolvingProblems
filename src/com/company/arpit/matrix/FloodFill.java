package com.company.arpit.matrix;

/*Fill matrix for given number with number provided*/
public class FloodFill {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 2, 1, 1, 1}, {2, 2, 1, 2, 2, 1, 1}, {0, 2, 2, 2, 1, 1, 1}, {1, 1, 0, 2, 1, 2, 1}, {1, 1, 2, 2, 1, 0, 0}};
        printMatrix(matrix);

        int toFill=10;
        int currentFill=2;
        floodFill(matrix,toFill,currentFill);
       System.out.println("-------Changed matrix------");
        printMatrix(matrix);
    }

    private static void floodFill(int[][] matrix, int toFill, int currentFill) {


        floodFills(matrix,0,3,toFill,currentFill);

    }

    private static void floodFills(int[][] matrix, int r, int c, int toFill, int currentFill) {

        if(r<0 || r>=matrix.length || c<0 || c>=matrix[0].length )
        {
            return;
        }
        if( matrix[r][c]!=currentFill)
        {
          return;
        }

        matrix[r][c]=toFill;

        floodFills(matrix,r-1,c,toFill,currentFill);
        floodFills(matrix,r+1,c,toFill,currentFill);
        floodFills(matrix,r,c-1,toFill,currentFill);
        floodFills(matrix,r,c+1,toFill,currentFill);
    }

    private static void printMatrix(int[][] matrix) {
        int c = matrix[0].length;
        printMatrixs(matrix, 0, c);
    }

    private static void printMatrixs(int[][] matrix, int r, int c) {

        if (r >= matrix.length)
            return;

        for (int i = 0; i < c; i++) {
            System.out.print(matrix[r][i]+" ");
        }
        System.out.println();

        printMatrixs(matrix, r + 1, c);
    }


}

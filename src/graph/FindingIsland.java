package graph;

public class FindingIsland {
    public static void main(String[] args) {
        int[][] matrix={{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int numberOfIslands=findIslands(matrix);
        System.out.println(numberOfIslands);
    }

    private static int findIslands(int[][] matrix) {
        int result=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==1)
                {
                    result++;
                    dfsFill(matrix,i,j);
                }
            }
        }
        return result;
    }

    private static void dfsFill(int[][] matrix, int i, int j) {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]!=1)
            return ;
        matrix[i][j]=2;
        dfsFill(matrix,i+1,j);
        dfsFill(matrix,i-1,j);
        dfsFill(matrix,i,j-1);
        dfsFill(matrix,i,j+1);

    }
}

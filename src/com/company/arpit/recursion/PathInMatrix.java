package com.company.arpit.recursion;
/*Given r*c matrix find paths from top left to bottom right. You can move right or down only*/
public class PathInMatrix {

    public static void main(String[] args) {

        int row =10;
        int column=10;

        int paths=findAllPath(row,column);
        System.out.println(paths);

    }

    private static int findAllPath(int r,int c) {

        if(r==0 && c==0)
        {
            return 0;
        }

        if(r==1 || c==1)
            return 1;


        return findAllPath(r-1,c) +findAllPath(r,c-1);

    }


}

package com.company.arpit.misc;

public class PurchaseSellOnce {
    public static void main(String[] args) {
        int[] arr={7,1,5,6,4};
         int result=findMaxProfitWithExtraSpace(arr);
         System.out.print(result);
         int resultMax=findMaxProfit(arr);
         System.out.print(resultMax);
    }

    private static int findMaxProfit(int[] arr) {

        int minSoFar=arr[0];
        int maxProfit=0;
        for(int i=1;i<arr.length;i++)
        {
            minSoFar=Math.min(arr[i],minSoFar);
            int profit=arr[i]-minSoFar;
            maxProfit=Math.max(profit,maxProfit);
        }
        return maxProfit;


    }

    private static int findMaxProfitWithExtraSpace(int[] arr) {
        int length=arr.length;
        int[] aux=new int[length];
        aux[length-1]=arr[length-1];
        for(int i=length-2;i>=0;i--)
        {
            aux[i]=Math.max(arr[i],aux[i+1]);
        }
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            int diff=aux[i]-arr[i];
            max=Math.max(diff,max);
        }
     return max;

    }

}

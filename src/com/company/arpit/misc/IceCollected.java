package com.company.arpit.misc;

/*
Find Ice collected on different days
 */
public class IceCollected {

    public static void main(String[] args) {
        int[] arr={3,1,2,4,0,1,3,2};
        int result=findIceCollector(arr);
        System.out.print(result);

    }

    private static int findIceCollector(int[] arr) {
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        left[0]=arr[0];

        for(int i=1;i<arr.length;i++)
        {
            left[i]=Math.max(left[i-1],arr[i]);
        }
        right[arr.length-1]=arr[arr.length-1];
        for(int j=arr.length-2;j>=0;j--)
        {
            right[j]=Math.max(right[j+1],arr[j]);
        }

        int iceCollected=0;
        for(int i=0;i<arr.length-1;i++)
        {
            iceCollected+=Math.min(left[i],right[i])-arr[i];
        }

        return iceCollected;


    }
}

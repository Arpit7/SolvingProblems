package array;
//Moore's Algo
public class MajorityVote {
    public static void main(String[] args) {
        int[] arr={1,1,2,3,1};
        int result=findMajority(arr);
        System.out.print(result);
    }

    private static int findMajority(int[] arr) {
        int ansIndex=0;
        int count=1;
        int majority=arr.length/2;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[1]!=arr[ansIndex])
            {
                count--;
            }else
            {
                count++;
            }
            if(count==0)
            {
                ansIndex=i;
                count=1;
            }
        }
        int frequency=0;
        if(count>0)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==arr[ansIndex])
                    frequency++;
            }
        }

        if(frequency>=majority)
            return arr[ansIndex];
        else
            return -1;


    }
}

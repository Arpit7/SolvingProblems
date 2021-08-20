package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Integer[][] arr={{1,2},{3,4},{5,6}};
        List<List<Integer>> lst=new ArrayList<>();
        for(Integer[] obj:arr)
        {
            lst.add(Arrays.asList(obj));
        }
        System.out.println(lst);


        Object[] arr1=lst.toArray();





    }
}

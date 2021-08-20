package mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalMerge {
    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9},{1,10}};
        Solution s = new Solution();
        int[][] result=s.merge(intervals);
        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i][0]);
            System.out.print(",");
            System.out.print(result[i][1]);
            System.out.print("---");

        }
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {

        List<Interval> lst=new ArrayList<>();
        List<Interval> result=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            lst.add(new Interval(intervals[i][0],intervals[i][1]));
        }


        Collections.sort(lst);
        int start=lst.get(0).start;
        int end=lst.get(0).end;
        for(int i=1;i<intervals.length;i++)
        {
            if(end>=lst.get(i).start)
            {
                end=Math.max(end,lst.get(i).end);
            }else
            {
                result.add(new Interval(start,end));
                start=lst.get(i).start;
                end=lst.get(i).end;

            }
        }
        result.add(new Interval(start,end));

        int[][] results=new int[result.size()][2];
        int j=0;
        for(Interval interval:result)
        {
            results[j][0]=interval.start;
            results[j][1]=interval.end;
            j++;
        }
        return results;
    }


}

class Interval implements Comparable<Interval>{
    int start;
    int end;
    Interval(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
    @Override
    public int compareTo(Interval that)
    {
        return this.start-that.start;
    }
}





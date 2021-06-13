package com.company.arpit.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        /*
        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]

        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
         */

        int[] nums = {2, 7, 11, 15};
        int target = 9;


        List<Integer> result = getTwoSumIndex(nums, target);
        System.out.println(result);

        int[] nums1 = {3,2,4};
        int target1 = 6;


        List<Integer> result1 = getTwoSumIndex(nums1, target1);
        System.out.println(result1);

        int[] nums2 = {3,3};
        int target2 = 6;


        List<Integer> result2 = getTwoSumIndex(nums2, target2);
        System.out.println(result2);


    }

    private static List<Integer> getTwoSumIndex(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null && map.get(diff) != i) {
                result.add(i);
                result.add(map.get(diff));
                return result;
            } else {
                map.put(nums[i], i);
            }

        }

        return result;


    }
}

package com.company.arpit.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Largest Sum continues array*/
public class KadaneAlgo {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max_so_far = Integer.MIN_VALUE;
        int max_till_now = 0;


        for (int i = 0; i < arr.length; i++) {
            max_till_now += arr[i];

            if (max_till_now < 0)
                max_till_now = 0;
            else if (max_so_far < max_till_now) {
                max_so_far = max_till_now;
            }

        }

        System.out.println(max_so_far);


    }



}

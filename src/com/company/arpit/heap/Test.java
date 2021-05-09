package com.company.arpit.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>( );

        priorityQueue.add(20);
        priorityQueue.add(30);
        priorityQueue.add(40);

        System.out.println(priorityQueue.peek());


    }

}

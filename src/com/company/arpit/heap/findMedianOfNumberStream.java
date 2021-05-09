package com.company.arpit.heap;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

/*
* Design a class to calculate the median of a number stream. The class should have the following two methods:

insertNum(int num): stores the number in the class
findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
*
* */
public class findMedianOfNumberStream {

    private final static PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private final static PriorityQueue<Double> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

    public static void main(String[] args) {
        /*
        * 1. insertNum(3)
        2. insertNum(1)
        3. findMedian() -> output: 2
        4. insertNum(5)
        5. findMedian() -> output: 3
        6. insertNum(4)
        7. findMedian() -> output: 3.5
        *
        * */

        insertNum(3);
        insertNum(1);

        System.out.println(findMedian().orElse(-1.0));
        insertNum(5);
        System.out.println(findMedian().orElse(-1.0));
        insertNum(4);
        System.out.println(findMedian().orElse(-1.0));
    }

    private static void insertNum(double num) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        balanceHeap();


    }

    public static void balanceHeap() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }


    }

    private static Optional<Double> findMedian() {

        if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.size() == minHeap.size()) {
            return Optional.of((maxHeap.peek() + minHeap.peek()) / 2);

        } else {
            return Optional.ofNullable(maxHeap.peek());
        }


    }
}
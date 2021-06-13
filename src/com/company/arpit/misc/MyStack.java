package com.company.arpit.misc;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
        for(int i = 1; i < q1.size(); i ++) { //rotate the queue to make the tail be the head
            q1.add(q1.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        if(this.empty())
            return -1;

        return q1.poll();

    }

    /**
     * Get the top element.
     */
    public int top() {

        if(this.empty())
            return -1;

        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

        return q1.isEmpty();

    }


}


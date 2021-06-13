package com.company.arpit.misc;

public class Test {

    public static void main(String[] args) {

        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        System.out.println("param_2=" + param_2);
        int param_3 = obj.top();
        System.out.println("param_3=" + param_3);
        boolean param_4 = obj.empty();
        System.out.println("param_4=" + param_4);
    }
}

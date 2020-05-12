package com.mason.cartoon.chapter05;

import java.util.Stack;

/**
 * Created by mwu on 2020/1/6
 * 最小栈
 */
public class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(9);
        minStack.push(7);
        minStack.push(3);
        minStack.push(8);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    private void push(int element) {
        mainStack.push(element);
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    private int pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    private int getMin() throws Exception {
        if (mainStack.isEmpty()) {
            throw new Exception("stack is empty.");
        }

        return minStack.peek();
    }
}


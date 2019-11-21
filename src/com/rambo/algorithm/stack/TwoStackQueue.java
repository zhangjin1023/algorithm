package com.rambo.algorithm.stack;

import java.util.Stack;

/**
 * @description:用两个栈实现队列
 * @Date : 2019/11/21 11:23
 * @Author : zhang_jin
 */
public class TwoStackQueue<T> {
    // 辅助栈，push元素的时候，需要临时存储stack2 弹栈出来的所有元素，
    Stack<T> stack1 = new Stack<>();
    // 存储栈
    Stack<T> stack2 = new Stack<>();

    public static void main(String[] args) {
        TwoStackQueue<Integer> twoStackQueue = new TwoStackQueue<>();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);

        Integer head = twoStackQueue.peek();
        System.out.println(head);

        while (!twoStackQueue.isEmpty()) {
            Integer remove = twoStackQueue.remove();
            System.out.println(remove);
        }
    }

    public void add(T e) {
        if (stack2.isEmpty()) {
            stack2.push(e);
        } else {
            // stack2非空，需要把所有元素暂存到stack1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            // 此时stack2为空，将新元素入栈
            stack2.push(e);
            // 将stack1中暂存的所有元素弹出，重新入栈stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public T peek() {
        if (stack2.isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        return stack2.peek();
    }

    public T remove() {
        if (stack2.isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack2.isEmpty();
    }

}

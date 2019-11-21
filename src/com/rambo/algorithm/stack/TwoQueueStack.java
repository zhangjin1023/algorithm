package com.rambo.algorithm.stack;

import java.util.LinkedList;

/**
 * @description:用两个队列实现栈
 * @Date : 2019/11/21 12:15
 * @Author : zhang_jin
 */
public class TwoQueueStack<T> {

    LinkedList<T> queue1 = new LinkedList<>();
    LinkedList<T> queue2 = new LinkedList<>();

    public static void main(String[] args) {
        TwoQueueStack<Integer> stack = new TwoQueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.print("栈顶元素出栈：");
        while (!stack.isEmpty()) {
            System.out.print(" " + stack.pop());
        }
    }

    public void push(T e) {
        if (queue1.isEmpty()) {
            queue1.add(e);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
            // 此时queue2为空
        } else if (queue2.isEmpty()) {
            queue2.add(e);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            // 此时queue1为空
        }
    }

    public T pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        if (queue1.isEmpty()) {
            return queue2.remove();
        } else {
            return queue1.remove();
        }
    }

    public boolean isEmpty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }

}

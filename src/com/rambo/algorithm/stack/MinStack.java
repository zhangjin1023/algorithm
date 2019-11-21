package com.rambo.algorithm.stack;

import java.util.Stack;

/**
 * @description:包含min函数的栈
 *定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *在该栈中，调用min、push和pop方法。要求的时间复杂度均为O(1)
 * @Date : 2019/11/21 10:41
 * @Author : zhang_jin
 */
public class MinStack {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
//        minStack.push(4);
//        minStack.push(4);
//        minStack.push(1);

        System.out.println("栈最小值："+minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println("栈最小值："+minStack.min());
    }

    Stack<Integer> stack = new Stack<>();
    // 栈顶保存最小值
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer e) {
        stack.push(e);
        if (minStack.isEmpty() || minStack.peek() >= e) {
            minStack.push(e);
        }
    }

    public void pop() {
        Integer e = stack.pop();
        if (minStack.peek() == e) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public Integer min() {
        return minStack.pop();
    }

}

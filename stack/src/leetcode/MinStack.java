package leetcode;

import java.util.Stack;

/**
 * 155. Min Stack
 */
public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        } else {
            if (minStack.peek() >= val) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        int el = stack.pop();
        if (el == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

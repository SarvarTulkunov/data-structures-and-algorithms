package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {

    private final Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, span});
        return span;
    }
}


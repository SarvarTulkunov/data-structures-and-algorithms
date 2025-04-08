package leetcode;

import java.util.Stack;

public class P_682 {

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();
        int currentRecord = 0;

        for (String op : operations) {
            switch (op) {
                case "+":
                    if (!stack.isEmpty()) {
                        int x1 = stack.pop();
                        int x2 = stack.pop();
                        stack.push(x2);
                        stack.push(x1);
                        stack.push(x1 + x2);
                    }
                    break;
                case "C":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "D":
                    if (!stack.isEmpty()) {
                        currentRecord = stack.peek() * 2;
                        stack.push(currentRecord);
                    }
                    break;
                default:
                    currentRecord = Integer.parseInt(op);
                    stack.push(currentRecord);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(calPoints(new String[]{"1", "C"}));
    }
}

package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class P_735 {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.pop();
                if (Math.abs(top) > Math.abs(asteroid)) {
                    stack.push(top);
                    destroyed = true;
                    break;
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, -5, 2})));
    }
}

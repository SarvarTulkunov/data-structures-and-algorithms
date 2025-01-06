package leetcode;

import java.util.Arrays;

public class P_881 {

    public static int numRescueBoats(int[] people, int limit) {

        int numberOfBoats = 0;
        int left = 0, right = people.length - 1;

        Arrays.sort(people);

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            numberOfBoats++;
        }

        return numberOfBoats;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 8, 7, 1, 4}, 9));
    }
}

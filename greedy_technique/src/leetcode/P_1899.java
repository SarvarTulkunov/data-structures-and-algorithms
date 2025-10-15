package leetcode;

/**
 * 1899. Merge Triplets to Form Target Triplet
 */
public class P_1899 {

    /**
     * Brute Force - Greedy
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        if (triplets[0][0] == target[0] &&
                triplets[0][1] == target[1] &&
                triplets[0][2] == target[2]) {
            return true;
        }

        int l = 0, r = 0;
        boolean isFirst = true;
        while (r < triplets.length) {
            if (triplets[r][0] > target[0] ||
                    triplets[r][1] > target[1] ||
                    triplets[r][2] > target[2]) {
                r++;
                continue;
            }

            if (isFirst) {
                l = r;
                isFirst = false;
            }

            triplets[r][0] = Math.max(triplets[l][0], triplets[r][0]);
            triplets[r][1] = Math.max(triplets[l][1], triplets[r][1]);
            triplets[r][2] = Math.max(triplets[l][2], triplets[r][2]);

            l = r;
            if (triplets[r][0] == target[0] &&
                    triplets[r][1] == target[1] &&
                    triplets[r][2] == target[2]) {
                return true;
            }

            r++;
        }

        return false;
    }

    /**
     * Optimized - Greedy
     */
    public boolean mergeTriplets2(int[][] triplets, int[] target) {
        boolean a = false, b = false, c = false;

        for (int[] t : triplets) {
            // Skip if any element exceeds target — can't use this triplet
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;

            // Check which positions match target
            if (t[0] == target[0]) a = true;
            if (t[1] == target[1]) b = true;
            if (t[2] == target[2]) c = true;

            // If all matched, we can form target
            if (a && b && c)
                return true;
        }

        return a && b && c;
    }
}

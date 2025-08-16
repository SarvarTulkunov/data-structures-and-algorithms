package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 98. Validate Binary Search Tree
 */
public class P_98 {

    /**
     * Solution 1 - DFS
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(TreeNode root, int left, int right) {
        if (root == null) return true;
        if (!(root.val < right && root.val > left)) return false;

        return validate(root.left, left, root.val) && validate(root.right, root.val, right);
    }

    /**
     * Solution 2 - BFS
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, Long.MIN_VALUE, Long.MAX_VALUE});

        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            TreeNode node = (TreeNode) current[0];
            long left = (long) current[1];
            long right = (long) current[2];

            if (!(left < node.val && node.val < right)) {
                return false;
            }

            if (node.left != null) {
                queue.offer(new Object[]{node.left, left, (long) node.val});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, (long) node.val, right});
            }
        }

        return true;
    }
}

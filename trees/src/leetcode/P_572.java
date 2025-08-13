package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 572. Subtree of Another Tree
 */
public class P_572 {

    /**
     * Solution 1 - DFS
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Solution 2 - BFS
     */
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {

        if (root == null) return false;

        if (subRoot == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        // Add the root node
        queue.add(root);

        // BFS traversal
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Check if this node's subtree matches
            if (isSameTree(current, subRoot)) return true;

            // BFS: add children
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}

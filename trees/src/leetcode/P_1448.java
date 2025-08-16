package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1448. Count Good Nodes in Binary Tree
 */
public class P_1448 {

    private int counter = 0;

    /**
     * Solution 1 - DFS
     */
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return counter;
    }

    private void dfs(TreeNode root, int maxVal) {
        if (root == null) return;
        if (root.val >= maxVal) counter++;
        dfs(root.left, Math.max(root.val, maxVal));
        dfs(root.right, Math.max(root.val, maxVal));
    }

    /**
     * Solution 2 - BFS
     */
    public int goodNodes2(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, Integer.MIN_VALUE));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.key();
            int maxval = pair.value();
            if (node.val >= maxval) {
                res++;
            }
            if (node.left != null) {
                q.offer(new Pair<>(node.left, Math.max(maxval, node.val)));
            }
            if (node.right != null) {
                q.offer(new Pair<>(node.right, Math.max(maxval, node.val)));
            }
        }
        return res;
    }
}

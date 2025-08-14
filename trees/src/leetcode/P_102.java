package leetcode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class P_102 {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * Solution 1 - BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return Collections.emptyList();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    level.add(curr.val);
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
            }

            if (!level.isEmpty()) {
                res.add(level);
            }
        }

        return res;
    }


    /**
     * Solution 2 - DFS
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }

        res.get(depth).add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

}

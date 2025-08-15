package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */
public class P_199 {

    List<Integer> res = new ArrayList<>();

    /**
     * Solution 1 - BFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            TreeNode rightMostNode = null;
            for (int i = 0; i < size; i++) {
                rightMostNode = q.poll();
                if (rightMostNode != null) {
                    if (rightMostNode.left != null) q.add(rightMostNode.left);
                    if (rightMostNode.right != null) q.add(rightMostNode.right);
                }
            }

            if (rightMostNode != null) {
                ans.add(rightMostNode.val);
            }
        }

        return ans;
    }

    /**
     * Solution 2 - DFS
     */
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(node.val);
        }

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}

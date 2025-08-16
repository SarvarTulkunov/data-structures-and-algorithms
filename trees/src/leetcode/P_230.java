package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 */
public class P_230 {

    /**
     * Solution 1 - Inorder Traversal
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);
        return list.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    /**
     * Solution 2 - Recursive DFS (Optimal)
     */
    public int kthSmallest2(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs2(root, tmp);
        return tmp[1];
    }

    private void dfs2(TreeNode node, int[] tmp) {
        if (node == null) {
            return;
        }

        dfs2(node.left, tmp);
        tmp[0] -= 1;
        if (tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }
        dfs2(node.right, tmp);
    }


    /**
     * Solution 3 - Iterative DFS (Optimal)
     */
    public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }
}

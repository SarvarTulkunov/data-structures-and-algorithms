package leetcode;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class P_104 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}

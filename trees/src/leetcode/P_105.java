package leetcode;

import java.util.Arrays;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class P_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid);

        root.left = buildTree(leftPreOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }
}

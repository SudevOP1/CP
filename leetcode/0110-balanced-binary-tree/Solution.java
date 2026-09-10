import java.lang.Math;

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static boolean checkRecursive(TreeNode node) {

        if (node == null) {
            return true;
        }

        if (!(checkRecursive(node.left) && checkRecursive(node.right))) {
            return false;
        }

        if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) {
            return false;
        }

        return true;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkRecursive(root);
    }
}

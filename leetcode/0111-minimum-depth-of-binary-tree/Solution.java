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

    private static int checkRecursive(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return checkRecursive(node.right) + 1;
        }
        if (node.right == null) {
            return checkRecursive(node.left) + 1;
        }
        return Math.min(checkRecursive(node.left) + 1, checkRecursive(node.right) + 1);
    }

    public int minDepth(TreeNode root) {
        return checkRecursive(root);
    }

}

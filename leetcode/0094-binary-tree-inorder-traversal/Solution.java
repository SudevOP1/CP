import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer> recursiveInorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // add left child
        if (root.left != null) {
            list.addAll(recursiveInorderTraversal(root.left));
        }

        // add self
        list.add(root.val);

        // add right child
        if (root.right != null) {
            list.addAll(recursiveInorderTraversal(root.right));
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        return recursiveInorderTraversal(root);
    }

}

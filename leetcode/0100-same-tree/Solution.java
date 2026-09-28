
class Solution {

    private boolean checkNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val && checkNode(p.left, q.left) && checkNode(p.right, q.right));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkNode(p, q);
    }

}

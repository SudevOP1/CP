import java.util.List;
import java.util.ArrayList;

class Solution {

    List<List<Integer>> treePathInts;

    public void dfs(TreeNode node, List<Integer> currentPath) {

        if (node.left == null && node.right == null) {
            currentPath.add(node.val);
            treePathInts.add(new ArrayList<>(currentPath));
            currentPath.removeLast();
            return;
        }

        currentPath.add(node.val);
        if (node.left != null) {
            dfs(node.left, currentPath);
        }
        if (node.right != null) {
            dfs(node.right, currentPath);
        }
        currentPath.removeLast();
    }

    public List<String> binaryTreePaths(TreeNode root) {

        treePathInts = new ArrayList<>();
        dfs(root, new ArrayList<Integer>());

        int n = treePathInts.size();
        List<String> treePaths = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            List<Integer> ithPath = treePathInts.get(i);
            int m = ithPath.size();
            StringBuilder sb = new StringBuilder(Integer.toString(ithPath.get(0)));

            for (int j = 1; j < m; j++) {
                sb.append("->");
                sb.append(ithPath.get(j));
            }

            treePaths.add(sb.toString());
        }

        return treePaths;
    }

}

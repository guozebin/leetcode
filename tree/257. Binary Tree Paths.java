/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        
        if (root == null) {
            return paths;
        }
        dfs(root,"", paths);

        return paths;
    }

    public void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        // 叶子
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);
            return;
        } else {
            path += root.val + "->";
            dfs(root.left, path, paths);
            dfs(root.right, path, paths);
        }
    }
}
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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumber(root, "");
        return this.sum;
    }

    private void sumNumber(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            sum += Integer.valueOf(path);
            return;
        }
        sumNumber(root.left, path);
        sumNumber(root.right, path);
    }
}
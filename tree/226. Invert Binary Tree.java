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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode invertedTree = new TreeNode(root.val);
        invertedTree.left = invertTree(root.right);
        invertedTree.right = invertTree(root.left);

        return invertedTree;
    }
}
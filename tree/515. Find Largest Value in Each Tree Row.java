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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return values;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                root = queue.remove();
                if (root.val > max) {
                    max = root.val;
                }
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }

            values.add(max);
        }

        return values;
    }
}
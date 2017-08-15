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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avrages = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double avrage = 0D;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.remove();
                avrage += root.val;
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            avrages.add(avrage / size);
        }

        return avrages;
    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        
        if (root == null) {
            return view;
        }
        
        view.add(root.val);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasView = false;
            for (int i = 0; i < size; i++) {
                root = queue.remove();
                if (root.right != null) {
                    queue.add(root.right);
                    if (!hasView) {
                        view.add(root.right.val);
                        hasView = true;
                    }
                }
                if (root.left != null) {
                    queue.add(root.left);
                    if (root.right == null && !hasView) {
                        view.add(root.left.val);
                        hasView = true;
                    }
                }
            }
        }

        return view;
    }
}
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
    // 利用层次遍历，直到访问最后一层
    // 先添加左元素，有左元素，不添加右元素，没有左元素，再添加右元素
    // 最后一个添加的元素则为最左元素
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int bottomVal = root.val;

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 填充标致，为 true 表示已经有最左边的元素
            boolean hasBottomVal = false;
            for (int i = 0; i <size; i++) {
                root = queue.remove();
                if (root.left != null) {
                    queue.add(root.left);
                    if (!hasBottomVal) {
                        bottomVal = root.left.val;
                        hasBottomVal = true;
                    }
                }
                if (root.right != null) {
                    queue.add(root.right);
                    // 该树没有左元素，则右元素当做最左元素
                    if (!hasBottomVal && root.left == null) {
                        bottomVal = root.right.val;
                        hasBottomVal = true;
                    }
                }
            }
        }

        return bottomVal;
    }
}
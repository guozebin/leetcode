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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum_dfs (root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSum_dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 以下代码会发生阻断，比如
        //          1
        //         /     
        //       -2
        //       /
        //      1
        //     /
        //   -1
        // 当要求 sum = -1 的时候，有以下情况：1->-2, 1->-2->1->-1, -1
        // 如果采用下列代码，则阻断，当 1->-2 阻止往下走，1->-2->1->-1, -1 不走
        // if (sum == root.val) {
        //     return 1;
        // }
        if (sum == root.val) {
            return 1 + pathSum_dfs(root.left, sum - root.val) + pathSum_dfs(root.right, sum - root.val);
        }

        return pathSum_dfs(root.left, sum - root.val) + pathSum_dfs(root.right, sum - root.val);
    }
}
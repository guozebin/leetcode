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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();

        if (root == null) {
            return paths;
        }
        pathSum_dfs(root ,"", sum, paths);

        return paths;
    }

    //
    // path 用 String 类型用于自动堆栈
    //
    public void pathSum_dfs(TreeNode root, String path, int sum, List<List<Integer>> paths) {
        // 叶子
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            path += root.val;
            String[] nodes = path.split(",");
            List<Integer> lstPath = new ArrayList<>();
            for (int i = 0; i < nodes.length; i++) {
                if (!nodes[i].equals("-")) {
                    lstPath.add(Integer.parseInt(nodes[i]));
                }
            }
            paths.add(lstPath);
            return;
        } else {
            path += root.val + ",";
            pathSum_dfs(root.left, path, sum - root.val, paths);
            pathSum_dfs(root.right, path, sum - root.val, paths);
        }
    }
}
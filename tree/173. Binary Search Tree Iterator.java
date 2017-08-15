/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    int current = 0;
    private List<TreeNode> list;

    public BSTIterator(TreeNode root) {
        if (root == null) {
            return;
        }
        list = new ArrayList<>();
        dfs(root, this.list);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return list != null && this.current < list.size();
    }

    /** @return the next smallest number */
    public int next() {
       return list.get(current++).val;
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
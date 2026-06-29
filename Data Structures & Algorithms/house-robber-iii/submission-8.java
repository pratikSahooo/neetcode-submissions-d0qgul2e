/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     // int res = 0;
//     public int rob(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         int res = root.val;
//         if (root.left != null) {
//             res += rob(root.left.left) + rob(root.left.right);
//         }
//         if (root.right != null) {
//             res += rob(root.right.left) + rob(root.right.right);
//         }

//         res = Math.max(res, rob(root.left) + rob(root.right));
//         return res;
//     }
// }
public class Solution {
    private Map<TreeNode, Integer> cache;

    public int rob(TreeNode root) {
        cache = new HashMap<>();
        cache.put(null, 0);
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }

        int res = root.val;
        if (root.left != null) {
            res += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            res += dfs(root.right.left) + dfs(root.right.right);
        }

        res = Math.max(res, dfs(root.left) + dfs(root.right));
        cache.put(root, res);
        return res;
    }
}
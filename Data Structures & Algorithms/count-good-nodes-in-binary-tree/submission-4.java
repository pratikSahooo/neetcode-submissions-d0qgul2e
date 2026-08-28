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

class Solution {
    int res = 0 ;
    public int goodNodes(TreeNode root) {
        return  dfs(root,root.val);
    }
    // finding maximum good nodes in a tree ...
    public int dfs(TreeNode root,int maxVal) {
        if(root == null) return 0 ;

        res += (root.val >= maxVal) ? 1 : 0;
         maxVal = Math.max(maxVal, root.val);
         dfs(root.left,maxVal);
         dfs(root.right,maxVal); 
        return res ;        
    }

}

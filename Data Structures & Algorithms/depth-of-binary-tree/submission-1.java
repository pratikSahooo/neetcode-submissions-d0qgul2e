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
    public int maxDepth(TreeNode root) {
        // left , then right, then visting root by +1 so post order(DFS)
        if(root == null){
            return 0 ;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        // root 
        return (1 + Math.max(lh,rh)); 
    }
}

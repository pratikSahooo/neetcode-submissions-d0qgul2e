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
    int value = 0 ;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false ;
        }
        value += root.val ;
        if(value == targetSum) return true ;
        boolean leftRoot = hasPathSum(root.left,targetSum) ;
        boolean rightRoot = hasPathSum(root.right,targetSum) ;
        return leftRoot || rightRoot ;
    }
}
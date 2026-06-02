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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
    }
    public boolean dfs(TreeNode root,int currValue, int targetSum) {
        if(root == null){
            return false ;
        }
        currValue += root.val ;
        if(root.left==null && root.right==null) return currValue == targetSum ;
        boolean leftRoot = dfs(root.left,currValue,targetSum);
        boolean rightRoot = dfs(root.right,currValue,targetSum);
        return leftRoot || rightRoot ;
    }
}
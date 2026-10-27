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
        int max = 0 ;
    public int diameterOfBinaryTree(TreeNode root) {
        int [] arr = new int[2];
        dfs(arr,root);
        return arr[0];
    }
    public int dfs(int[]arr , TreeNode root){
        if(root == null){
            return 0;
        }   
        int left = dfs(arr,root.left);
        int right = dfs(arr,root.right);
        arr[0] = Math.max(arr[0],(left+right));
        return 1 + Math.max(left,right);
    }
}

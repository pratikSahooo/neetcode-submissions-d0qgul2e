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
    public boolean isCompleteTree(TreeNode root) {
        int n = count(root);
        return dfs(root,n,0);
    }

    public int count(TreeNode root) {
        if(root == null) return 0 ;
        return  1+count(root.left)+count(root.right) ;
    }

    public boolean dfs(TreeNode root,int n,int indexcount){
        if(root == null) return true ;
        
        if(indexcount >= n) return false ;

        return dfs(root.left,n,2*indexcount+1) && dfs(root.right,n,2*indexcount+2);
    }

    
}
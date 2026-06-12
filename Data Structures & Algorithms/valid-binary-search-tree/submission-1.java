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
    public boolean isValidBST(TreeNode root) {
        return dfsCheck(root,Integer.MAX_VALUE,Integer.MIN_VALUE);

    }
    
    public boolean dfsCheck(TreeNode root,int right,int left){
        if(root == null) return true ;

        if(root.val < left || root.val > right) return false;

        return dfsCheck(root.left,root.val,left) && dfsCheck(root.right,right,root.val);
    }

}

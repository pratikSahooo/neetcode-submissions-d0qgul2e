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
    public void recoverTree(TreeNode root) {
        recoverTreeLogic(root,root.right,root.left);
    }

     public void recoverTreeLogic(TreeNode root,TreeNode right,TreeNode left) {
        if(root == null) return ;

        if(left!=null && root.val<left.val){
            swap(root,left);
            recoverTreeLogic(root, root.right, root.left) ;
        }
        else if(right!=null &&root.val>right.val){
            swap(root,right);
            recoverTreeLogic(root, root.right, root.left) ;
        }
    }

    public void swap(TreeNode node,TreeNode newNode) {
        int temp = node.val;
        node.val =  newNode.val;
        newNode.val = temp ;
    }
}
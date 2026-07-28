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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root!=null && key > root.val){
            root.right = deleteNode(root.right,key);
        }

        else if(root!=null && key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            // Deleting node having only 1 child case
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // Deleting node having only 2 child case
            else{
                TreeNode justSmallerNewNode = inorderPredecessor(root.left);
                root.val = justSmallerNewNode.val;
                root.left = deleteNode(root.left,justSmallerNewNode.val) ;
            }
        }
        return root;
    }

    public TreeNode inorderPredecessor(TreeNode root){
        if(root.right != null){
            return inorderPredecessor(root.right);
        }
        return root ;
    }
}
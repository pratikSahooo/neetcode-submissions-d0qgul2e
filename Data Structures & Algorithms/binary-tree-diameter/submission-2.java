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
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int [] maxi = new int[]{0};
        lengthNode(root,maxi);
        return maxi[0];
    }
    public int lengthNode(TreeNode root,int[]maxi){
        if(root==null){
            return 0;
        }
        int lh = lengthNode(root.left);
        int rh = lengthNode(root.right);
        maxi[0] = Math.max(maxi[0],(lh+rh));
        return 1 + Math.max(lh,rh);
    }
}

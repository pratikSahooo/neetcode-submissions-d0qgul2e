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
    public int lengthNode(TreeNode root,int []maxi){
        if(root == null) return 0;

        int left = lengthNode(root.left,maxi);
        int right = lengthNode(root.right,maxi);
        maxi[0] = Math.max(maxi[0],(right+left));
        return 1 + Math.max(right,left);
    }
}

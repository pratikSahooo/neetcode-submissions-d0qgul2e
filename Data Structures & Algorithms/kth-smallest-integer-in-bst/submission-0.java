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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li = new ArrayList();
        inOrder(root,li);
        if(li.size()<k) return 0 ;
        return li.get(k-1);
    }

    public TreeNode inOrder(TreeNode root,List<Integer> li) {
        if(root == null) return null;

        inOrder(root.left,li);
        li.add(root.val);
        inOrder(root.right,li);

        return root;
    }
}

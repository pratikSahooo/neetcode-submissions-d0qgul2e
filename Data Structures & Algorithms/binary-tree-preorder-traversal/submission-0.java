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
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderSecTraversal(root,list);
        return list;
    }
    public void preorderSecTraversal(TreeNode root,ArrayList list){
    if(root==null){
            return;
        }
        preorderSecTraversal(root.left,list);
        list.add(root.val);
        preorderSecTraversal(root.right,list);
    }
}
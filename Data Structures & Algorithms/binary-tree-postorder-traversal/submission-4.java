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
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode node = root;
        TreeNode temp = null;
        Stack<TreeNode>stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node =node.left;
            }
            else if(stack.peek().right!=null){
                node = stack.peek().right;
            }
            else{
                temp = stack.pop();
                list.add(temp.val);
                while(!stack.isEmpty() && temp==stack.peek().right){
                    temp=stack.pop();
                    list.add(temp.val);
                }
            }
        }
        return list; 
    }
}
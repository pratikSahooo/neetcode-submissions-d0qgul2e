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
        Stack <TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode curr = root;
        while(curr !=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            if(stack.peek().right!= null){
                curr = stack.peek().right;
            }
            else{
                TreeNode temp = stack.pop();
                list.add(temp.val);
                while(!stack.isEmpty()&& temp == stack.peek().right){
                    temp = stack.pop();
                    list.add(temp.val);
                }
            }
        }
        return list;
    }
}
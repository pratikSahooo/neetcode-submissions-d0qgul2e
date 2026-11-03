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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        Queue <TreeNode> q = new LinkedList<>();
        List<Integer>list = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
               TreeNode poped = q.poll();
                if(poped.left != null){
                    q.offer(poped.left);
                }
                if(poped.right != null){
                    q.offer(poped.right);
                }
                if (i == size - 1) {
                    list.add(poped.val);
                }
            }
        }
        return list;
    }
}

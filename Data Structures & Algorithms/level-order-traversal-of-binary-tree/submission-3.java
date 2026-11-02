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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList <>();
        List<List<Integer>> list = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>level = new ArrayList<>();
            for(int i = size; i>0; i--){
                TreeNode poped = queue.poll();
                level.add(poped.val);
                if(poped.left!=null){
                    queue.offer(poped.left);
                }
                if(poped.right!=null){
                    queue.offer(poped.right);
                }
                if(i == 1){
                    list.add(level);
                }
            }
        }
        return list;
    }
}

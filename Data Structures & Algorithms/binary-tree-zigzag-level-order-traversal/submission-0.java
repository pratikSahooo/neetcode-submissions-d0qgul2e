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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();
        int level = 0 ;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> linklist = new LinkedList<>();
            while(size>0){
                TreeNode poped = q.poll();
                if(level%2!=0){
                    linklist.addFirst(poped.val);
                }
                else{
                    linklist.add(poped.val);
                }
                if(poped.left!=null) q.offer(poped.left);
                if(poped.right!=null) q.offer(poped.right);
                size--;
            }
            level++;
            list.add(linklist);
        }
        return list ;
    }
}
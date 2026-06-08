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
        // code here
        ArrayList<Integer>list = new ArrayList<>();
        if(root==null) return list ;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                TreeNode poped = q.poll();
                if(poped.left!=null){
                    q.offer(poped.left);
                }
                if(poped.right!=null){
                    q.offer(poped.right);
                }
                size--;
                if(size == 0){
                    list.add(poped.val);
                }
            }
        }
        return list;
    }
    }

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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> l = new ArrayList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size = q.size();
                Integer [] arr = new Integer[size];
                for(int i = 0 ; i <size ; i++){
                    TreeNode poped = q.poll();
                    arr[i] = poped.val;
                    if(poped.left!=null) {
                        q.offer(poped.left);
                    }
                    if(poped.right!=null) {
                        q.offer(poped.right) ;
                    }    
                }
                l.add(Arrays.asList(arr));
            }
        return l;
    }
}

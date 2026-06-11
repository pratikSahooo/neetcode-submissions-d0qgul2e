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
    HashMap<Integer,Integer> map =  new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        int n = inorder.length-1;
        int m = postorder.length-1;
        TreeNode node = constructTree(inorder,postorder,0,n,0,m);

        return node;
        
    }

    public TreeNode constructTree(int[] inorder, int[] postorder,
    int startIndexInOrder,int endIndexInOrder,int startIndexPostOrder,int endIndexPostOrder){

        if(startIndexInOrder>endIndexInOrder || startIndexPostOrder > endIndexPostOrder) return null;

        TreeNode root = new TreeNode (postorder[endIndexPostOrder]);
        
        int rootIndex = map.get(root.val);

        int leftTreeLength = rootIndex - startIndexInOrder ;

        root.left = constructTree(inorder, postorder,
     startIndexInOrder, rootIndex-1, startIndexPostOrder, startIndexPostOrder+leftTreeLength -1);
        root.right = constructTree(inorder, postorder,
     rootIndex+1,endIndexInOrder, startIndexPostOrder+leftTreeLength , endIndexPostOrder-1);

        return root ;
    }
}
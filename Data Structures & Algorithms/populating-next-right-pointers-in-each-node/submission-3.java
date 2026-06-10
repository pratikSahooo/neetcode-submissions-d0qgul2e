/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                Node poped = q.poll();
                size--;
                if(size>0){
                    poped.next = q.peek();
                }
                if(poped.left!=null){
                    q.offer(poped.left);
                }
                if(poped.right!=null){
                    q.offer(poped.right);
                }
            }
        }
        return root ;
    }
}
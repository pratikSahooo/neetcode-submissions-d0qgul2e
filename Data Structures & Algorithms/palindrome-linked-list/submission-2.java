/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head ;
        ListNode slow = head ;
        ListNode prev = null;
        ListNode newHead = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev= slow ;
            slow = slow.next;
            ListNode newNode = new ListNode(prev.val);
            if(newNode==null){
                newHead = newNode;
            }else{
                newNode.next = newHead;
                newHead = newNode;
            }
        }
        if(fast!=null){
            slow = slow.next;
        }
        while(newHead!=null && slow!=null){
            if(newHead.val != slow.val){
                return false ;
            }
            newHead = newHead.next;
            slow = slow.next;
        }
        return true;

    }
}
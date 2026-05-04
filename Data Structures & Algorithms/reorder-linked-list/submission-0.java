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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow =  head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast =  fast.next.next;
        }
        ListNode secHead = slow ;
        ListNode prev = null;
        while(secHead!=null){
            ListNode temp = secHead.next;
            secHead.next =  prev;
            prev =  secHead;
            secHead = temp ;
        }
        ListNode firstHead =  head ;
        secHead = prev;
        while(secHead.next!=null){
            ListNode temp1 = firstHead.next;
            ListNode temp2 = secHead.next;
            firstHead.next = secHead;
            secHead.next = temp1;
            firstHead = temp1;
            secHead = temp2;
        }
    }
}

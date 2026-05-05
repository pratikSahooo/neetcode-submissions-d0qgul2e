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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head ;
        ListNode slow = head ;
        ListNode prev = null ;
        int count = 0 ;
        while(count<n){
            fast = fast.next;
            count++;
        }
        if(fast == null){
            head = head.next;
            return head;
        }        
        ListNode dumm = head ;
        while(fast!=null){
            // if(head.next==fast){
            //     head = head.next;
            //     dumm.next = null;
            //     return head;
            // }
            fast = fast.next;
            prev = slow ;
            slow = slow.next;
        }
        prev.next = slow.next ;
        return head ;
    }
}

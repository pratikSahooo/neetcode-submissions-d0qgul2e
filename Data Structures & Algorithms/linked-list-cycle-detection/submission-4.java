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
    public ListNode cycleDetetctionNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean found = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow==fast){
                found = true ;
            }
        }
        if(!found){
            return null;
        }
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow; 
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}

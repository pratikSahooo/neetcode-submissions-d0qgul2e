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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 1 ;
        ListNode travelToLast = head ;
        ListNode trav =  head;
        ListNode newHeadStart ;
        if(head==null){
            return null;
        }
        while(travelToLast.next!=null){
            travelToLast =  travelToLast.next ;
            len++ ; 
        }
        int remaining= k % len;
        if(remaining == 0){
            return head;
        }
        int travCounter =1 ;
        while(travCounter<len-remaining){
            trav = trav.next;
            travCounter++;
        }
        newHeadStart = trav.next;
        trav.next = null ;
        travelToLast.next = head;
        return newHeadStart; 
    }
}
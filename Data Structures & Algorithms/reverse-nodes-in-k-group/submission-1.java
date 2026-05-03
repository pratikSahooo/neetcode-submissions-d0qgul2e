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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0 ;
        ListNode countHead = head;
        while(countHead !=null){
            len++;
            countHead = countHead.next;
        };
        int group = len/k ;
        int groupcount = 0;
        ListNode prevHead =  null;
        ListNode ansNode = null;
        ListNode currHead = head;
        while(groupcount!=group){
            ListNode prev =  null;
            ListNode curr = currHead;
            ListNode newnext = null;
        for(int i=1;i<=k;i++){
            newnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newnext;
        }
        if(prevHead == null){
            ansNode = prev;
        }
        else{
            prevHead.next = prev;
        }
        prevHead = currHead;
        currHead = curr;
        groupcount++;
        }
        
        return ansNode ;
    }
}

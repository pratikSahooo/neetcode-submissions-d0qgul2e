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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode leftNode= head;
        ListNode dummy = new ListNode(0,head);
        //dummy is just for pointing head and after the algorith and travese the whole linkedlist from start..
        ListNode beforNext = dummy;
        for(int i = 1; i<left;i++){
            beforNext = leftNode;
            leftNode = leftNode.next;
        }

        ListNode rightNode = leftNode;

        for(int i = left; i<right;i++){
            rightNode = rightNode.next;
        }
        
        ListNode backup = rightNode.next;
        ListNode prev = backup;
        ListNode trav = leftNode ;
        while(trav!=backup){
            ListNode temp = trav.next;
            trav.next = prev;
            prev = trav;
            trav = temp;
        }
        beforNext.next = rightNode;
        return dummy.next;

    }
}

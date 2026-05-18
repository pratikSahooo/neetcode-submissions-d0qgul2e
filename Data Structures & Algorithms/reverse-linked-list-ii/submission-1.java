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
        if (left == right){
            return head;
        }
        ListNode rightNode = head ;
        ListNode leftNode = head;
        ListNode fastleft = new ListNode(0);
        int count = 1 ;
        int count2 = 1 ;
        while(right!=count){
            if(right!=count){
            rightNode = rightNode.next;
            count++;
            }
        }
        for (int i = 1; i < left; i++) {
            beforeLeft = leftNode;
            leftNode = leftNode.next;
        }
        ListNode backUp = rightNode.next;
        ListNode prev = backUp;
        ListNode trav = leftNode;
        while(trav!=backUp){
            ListNode temp = trav.next;
            trav.next = prev;
            prev = trav;
            trav = temp ;
        }
        leftNode.next = backUp;
        return rightNode;
    }
}
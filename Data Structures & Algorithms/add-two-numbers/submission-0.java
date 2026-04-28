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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null ;
        ListNode l3head = l3;
        ListNode trav = l3;
        int carry = 0 ;
        while(l1!=null || l2!=null || carry !=0 ){
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = (v1+ v2 + carry)%10 ;
            carry = (v1+ v2 + carry)/10;
            if(l3head == null){
                l3 = new ListNode(sum);
                l3head = l3;
                trav = l3 ;
            }
            else{
                trav.next =new ListNode(sum);
                trav = trav.next ;
            }
            if(l1!=null){
                l1 =l1.next;
            }
            if(l2!= null){
                l2 = l2.next ;
            }
        }
        return l3head ;
    }
}

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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode tail = head; 
        ListNode trav =head.next;
        while(trav!=null){
            if(trav.val>=tail.val){
                tail = trav;
                trav = tail.next;
                continue;
            }
            tail.next = trav.next;
            ListNode prev = null ;
            ListNode t1 =  head ;
            while(t1!=tail.next){
                if(t1.val>=trav.val){
                    break;
                }
                prev = t1 ;
                t1 = t1.next;  
            }
            if(prev==null){
                trav.next = head ;
                head = trav;
            }else{
                trav.next = prev.next;
                prev.next = trav ; 
            }
            trav = tail.next;
        }
        return head ;
    }
}
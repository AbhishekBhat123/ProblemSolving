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
    private int sizeA(ListNode A){
        int c =0;
        while(A != null){
            A = A.next;
            c++;
        }
        return c;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){return null;}
        int size = sizeA(head);
        if(size < n){return null;}
        int c = 0;
        if(size - n==c){return head.next;}
        ListNode t = head;
        while(t != null && t.next != null){
            if(c + 1 == size - n){
                t.next = t.next.next;
                break;
            }
            c++;
            t = t.next;
        }
        return head;
    }
}
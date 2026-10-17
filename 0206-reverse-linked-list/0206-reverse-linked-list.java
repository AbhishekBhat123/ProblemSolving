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
    public ListNode reverseList(ListNode head) {
        ListNode t = head;
        ListNode rh = null;
        while(t != null){
            ListNode curr = t.next;
            t.next = rh;
            rh = t;
            t = curr;
        }
        return rh;
    }
}
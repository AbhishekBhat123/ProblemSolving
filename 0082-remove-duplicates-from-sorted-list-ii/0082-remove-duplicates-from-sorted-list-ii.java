
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check whether the current value is duplicated
            if (curr.next != null && curr.val == curr.next.val) {
                int duplicateValue = curr.val;

                // Skip all nodes having this duplicate value
                while (curr != null && curr.val == duplicateValue) {
                    curr = curr.next;
                }

                // Connect the previous unique node to the next node
                prev.next = curr;
            } else {
                // Current node is unique; move both pointers
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}

// Reverse a singly linked list.
//
// click to show more hints.
//
// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?
//

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stk = new Stack<>();
        while (head != null) {
            stk.push(head);
            head = head.next;
        }
        ListNode base = stk.pop();
        head = base;
        while (!stk.isEmpty()) {
            base.next = stk.pop();
            base = base.next;
        }
        base.next = null;

        return head;
    }
}

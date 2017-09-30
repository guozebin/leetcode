// Given a linked list, determine if it has a cycle in it.
//
// Follow up:
// Can you solve it without using extra space?
//

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       Map<ListNode, Object> map = new HashMap<>(0x100);

        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, null);
            head = head.next;
         }

         return false;
    }
}

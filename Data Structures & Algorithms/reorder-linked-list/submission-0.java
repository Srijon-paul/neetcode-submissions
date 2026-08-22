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
    public void reorderList(ListNode head) {
        int k = 0;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sec = reverse(slow.next);
        slow.next = null;
        fast = head;
        ListNode curr = head;
        ListNode tmp = sec;
        while(sec != null){
            curr = fast.next;
            tmp = sec.next;
            fast.next = sec;
            sec.next = curr;
            sec = tmp;
            fast = curr;
        }
    }

    ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode tmp = node;
        while(curr != null){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}

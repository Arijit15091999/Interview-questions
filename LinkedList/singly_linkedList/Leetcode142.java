package singly_linkedList;

public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode node = hasCycle(head);
        if (node == null)
            return node;
        ListNode slow = node, fast = head;

        int length = 0;

        do{
            length++;
            slow = slow.next;
        } while (slow != node);

        slow = head;

        while (length > 0) {
            length--;
            slow = slow.next;
        }

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
    
    public ListNode hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return slow;
        }

        return null;
    }
}

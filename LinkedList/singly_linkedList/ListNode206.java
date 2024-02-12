package singly_linkedList;

public class ListNode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        return helper(null, head, head);

        // return head;
    }
    
    private ListNode helper(ListNode prev, ListNode curr, ListNode head) {
        if (curr == null) {
            head = prev;
            return head;
        }

        ListNode h = helper(curr, curr.next, head);
        curr.next = prev;
        return h;
    }
}

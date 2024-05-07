package singly_linkedList;

public class LeetCode2816 {
    public static void main(String[] args) {
        ListNode head = new ListNode(9), tail = head;
        tail.next = new ListNode(9);
        tail = tail.next;
        tail.next = new ListNode(9);

        printLinkedList(head);

        ListNode res = doubleIt(head);

        printLinkedList(res);
    }

    private static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("END");
    }
    public static ListNode doubleIt(ListNode head) {
        head = reverse(head);
        int res = 0;
        ListNode dummyHead = new ListNode(), dummyTail = dummyHead, node = head;

        while(res != 0 || node != null) {
            if(node != null) {
                res += node.val * 2;
                node = node.next;
            }

            int val = res % 10;

            dummyTail.next = new ListNode(val);
            dummyTail = dummyTail.next;

            res /= 10;
        }

        reverse(head);
        dummyHead = reverse(dummyHead.next);
        return dummyHead;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

package singly_linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {
        this.val = 0;
        this.next = null;
    }
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
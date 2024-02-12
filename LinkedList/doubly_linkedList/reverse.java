package doubly_linkedList;

public class reverse {
    public static Node reverseDLL(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            if (prev != null)
                prev.prev = curr;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

public class doublyLinkedList {

    static class ListNode {
        int val;
        ListNode next, random;
        ListNode(int x) {
            val = x;
            next = random = null;
        }
    }

    public ListNode cloneList(ListNode A) {
        if (A == null) return null;

        ListNode curr = A;
        while (curr != null) {
            ListNode temp = new ListNode(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        curr = A;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode copyCurr = dummy;
        curr = A;
        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next; 
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print("[" + temp.val + " (Random: " + (temp.random != null ? temp.random.val : "NULL") + ")] -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head.random = head.next.next.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head.next.next;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = head;

        System.out.println("Original List:");
        printList(head);

        ListNode clonedHead = dll.cloneList(head);

        System.out.println("Cloned List:");
        printList(clonedHead);
    }
}

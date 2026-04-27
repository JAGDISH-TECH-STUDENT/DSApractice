public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class  removeLinkedListElements{
    public ListNode removeElements(ListNode head, int val) {
 
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        removeLinkedListElements remover = new removeLinkedListElements();
        ListNode result = remover.removeElements(head, 6);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

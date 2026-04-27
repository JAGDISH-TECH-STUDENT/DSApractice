
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class doublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return head;
        flattenDFS(head);
        return head;
    }
    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childTail = flattenDFS(curr.child);
                curr.next = curr.child;
                curr.child.prev = curr;
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                curr.child = null;
                last = childTail;
            } else {
                last = curr;
            }
            curr = next;
        }
        return last;
    }
    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.next.val = 2;
        head.next.next = new Node();
        head.next.next.val = 3;
        head.child = new Node();
        head.child.val = 4;
        head.child.next = new Node();
        head.child.next.val = 5;

        doublyLinkedList dll = new doublyLinkedList();
        Node flattenedHead = dll.flatten(head);
        Node curr = flattenedHead;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
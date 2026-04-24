class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class deleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {        
        ListNode head=new ListNode(4);
        head.next=new ListNode(5);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(9);
        deleteNode s=new deleteNode();
        s.deleteNode(head.next);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

}
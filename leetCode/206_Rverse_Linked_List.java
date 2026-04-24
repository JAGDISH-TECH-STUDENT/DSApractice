class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class removeNthFromEnd {
    public ListNode reverseList(ListNode head) {
        ListNode prv=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode later=cur.next;
            cur.next=prv;
            prv=cur;
            cur=later;
        }
        return prv;
    }
    public static void main(String[] args) {        
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        removeNthFromEnd s=new removeNthFromEnd();
        ListNode res=s.reverseList(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}

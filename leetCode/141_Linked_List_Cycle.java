import java.util.HashSet;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class cycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> s=new HashSet<>();
        while(head!=null){
            if(s.contains(head)==true)return true;
            s.add(head);
            head=head.next;
        }
        return false;
    }
    public static void main(String[] args) {        
        ListNode head=new ListNode(3);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(-4);
        head.next.next.next.next=head.next;
        cycle s=new cycle();
        System.out.println(s.hasCycle(head));
    }   
    
    
    
}
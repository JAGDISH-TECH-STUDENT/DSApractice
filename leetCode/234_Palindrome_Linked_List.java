class palindromeLinkedList {
     class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public boolean isPalindrome(ListNode head) {
       StringBuilder sb=new StringBuilder();
       ListNode curr=head;
       while(curr!=null){
        sb.append(curr.val);
        curr=curr.next;
       }
       String str=sb.toString();
       int size=str.length();
       int l=0, r=size-1;
       while(l<r){
        if(str.charAt(l)!=str.charAt(r)){
            return false;
        }
        l++;
        r--;
       }
       return true;
    }
    public static void main(String[] args) {
        palindromeLinkedList pll = new palindromeLinkedList();
        ListNode head = pll.new ListNode(1);
        head.next = pll.new ListNode(2);
        head.next.next = pll.new ListNode(2);
        head.next.next.next = pll.new ListNode(1);
        
        boolean result = pll.isPalindrome(head);
        System.out.println(result); // Output: true
    }
}
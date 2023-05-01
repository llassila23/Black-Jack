package SRC;

public class ListNode {
    String data;
    ListNode next;
    
    public ListNode(String data){
        this.data = data;
        this.next = null;
    }

    public ListNode(String data, ListNode next){
        this.data = data;
        this.next = next;
    }
    
}

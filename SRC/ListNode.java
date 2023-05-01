// Author: Lucas Lassila
// Class: CS 145
// Assingment : Phonebook
// 5/1/23
// This is the Object file, it will create an instance of the ListNode object to be acted upon
// by the Manager.java file

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

package SRC;

public class Manager {
    ListNode list = new ListNode("End List"); // creates new ListNode Object // 
    // End List is not used as a node (i think)

    private ListNode front; // reference to the first ListNode

public void Manager(){ // constructor
        front = null; // set front pointer = to null
        
    }

    public void print(){

        ListNode current = front; // current node 

        while (current!=null){ // while current node has data

            System.out.println(current.data); // print

            current = current.next; // advance current node
        }
    }

    public void add(String entry){ // add data
        if(front==null){ // if the front node is empty, add data here
            front = new ListNode(entry);

        }else{
            ListNode current = front; // set current node to first node
            while(current.next!= null){ // while pointer node is not null (aka end of list)
                current = current.next; // advance current
            }    // end while
            current.next = new ListNode(entry);
        }// if else
    } // end add

    public String get(int index){
        ListNode current = front; // start at front
            for (int i = 0; i<index; i++){ // traverse until index is reached
                current = current.next;
            }// end for loop
            String entry = current.data; // set a string equal to the data at that index
            return entry;
    }// end get()
    
}

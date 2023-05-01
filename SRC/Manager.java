// Author: Lucas Lassila
// Class: CS 145
// Assingment : Phonebook
// 5/1/23
// This is the Manager file, it will create an instance of the ListNode object and is called 
// by the Main.java file


package SRC;
import java.util.Scanner;

public class Manager {

    ListNode list = new ListNode("End List"); // creates new ListNode Object // 
    // End List is not used as a node (i think)

    private ListNode front; // reference to the first ListNode

    Scanner input = new Scanner(System.in);
    private int choice = 0; // menu input
    private int sIndex = 0; // index to be set by search and used by section
    private int index = 0; // index value to be used by get, set by
   


    public void Manager(){ // constructor
        front = null; // set front pointer = to null
    }

    public void menu(){
        do{ 
        System.out.println();
        System.out.println("Enter 1 to add an entry");
        System.out.println("Enter 2 to display an entry");
        System.out.println("Enter 3 to edit an entry");
        System.out.println("Enter 4 to delete an entry");
    
        choice = input.nextInt();

            switch(choice){
                case 1:
                    newEntry();
                    break;
                case 2:
                    sIndex = search(); // takes user input, returns locatation as number relative to front = 0
                    index = section(sIndex); // finds what entry section search value is located in
                    for( int i = index; i <= (index+=4); i++){
                        System.out.println(get(i));
                    }
                 
                    break;
                case 3:
                    // search();
                    // edit();
                    break;   
                case 4:
                    // search();
                    // delete
                    break;
             }//end case switch
        }while(choice != 1 || choice != 2 || choice != 3 || choice != 4); // end menu loop

    }// end menu method

    public void newEntry(){
        System.out.println();
        System.out.println("Enter a First Name");
            add(input.next());
        System.out.println("Enter a Last Name");
            add(input.next());
        System.out.println("Enter a Phone Number with no spaces");
           add(input.next());
        System.out.println("Enter a Street Name");
            add(input.next());
        System.out.println("Enter a City");
            add(input.next());
    }// end newEntry()



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

    public String get(int index){//search by location
        ListNode current = front; // start at front
            for (int i = 0; i<index; i++){ // traverse until index is reached
                current = current.next;
            }// end for loop
            String entry = current.data; // set a string equal to the data at that index
            return entry;
    }// end get()

    public int search(){ // return int to be used in get
        int sIndex = 0;
        System.out.println("Enter a name or number: ");
        String srchStr = input.next();// string for searching by name, num, city ect.
        ListNode current = front; // start at front
        String entry = current.data;
            while(!entry.contains(srchStr) && current.next != null){
                entry = current.data;
                current  = current.next; 
                sIndex++;
            }
            return sIndex;

    }// end search

    public int section(int sIndex){
        int index = sIndex % 5 ;// if index = 0, search value is in the first entry, each entry is 5 ListNodes
        return index;
    }
    
}

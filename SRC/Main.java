package SRC;

public class Main {
    public static void main(String[]args){

        Manager book = new Manager();

            book.add("test");
            book.add("the");
            book.add("12345");

            book.print();
            System.out.println(book.get(2));

    }
    
}

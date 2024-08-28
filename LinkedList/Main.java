import java.util.*;
public class Main {

    // Node class representing each element in the LinkedList
    public static class Node {
        int data;
        Node next;
    }

    // LinkedList class to manage the list
    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        // Method to add an element to the end of the list
        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        // Method to display the elements in the LinkedList
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

      public  int size() {
            System.out.println(size);
            return size;
        }

        public void removeFirst() {
            if(size == 0) {
                System.out.println("List is empty");
            }else if(size == 1) {
                head = tail = null;
                size = 0;
            }else
            head = head.next;
            size--;
        }


        public int getFirst() {
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }

            
        }

        public int getLast() {
            if(size == 0) {
                System.out.println("List is empty");
                return -1;
            }else{
                return tail.data;
            }
        }


        public int getAt(int idx) {
            if(size == 0) {
                System.out.println("list is empty");
                return -1;
            } else if( idx == 0 || idx == size) {
                System.out.println("invalid arguments");
                return -1;
            }else {
                Node temp = head;
               for(int i =0; i < idx; i++) {
                temp = temp.next;

               }
               return temp.data;
            }
        }


        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if(size == 0) {
                tail = temp;
            }

            size++; 
        }


        public void addAT(int idx , int val) {
            if(idx < 0 ||  idx > size  ) {
                System.out.println("invalid arguments");

            }else if( idx == 0) {
                addFirst(val);

            }else if(idx == size) {
                addLast((val));
            }else {
                Node node = new Node();
                node.data = val;
                 
                Node temp = head;
                for(int i =0; i < idx -1; i++) {
                    temp = temp.next;
                    
                }

                node.next = temp.next;
                temp.next = node; 

                size++;
            }
        }



        public void removeLast() {
            if(size == 0) {
                System.out.println("List is empty");
            }else if(size == 1) {
                head = tail = null;
                size = 0;
            }else {
               Node temp = head;
               
               for(int i =0 ; i < size -2; i++) {
                temp = temp.next;
               }

               tail = temp;
               temp.next = null;
               size--; 
            }
            
        }

        
        private Node getNodeAt(int idx) {
            Node temp = head;
            for(int i =0; i < idx; i++) {
                temp = temp.next;
            }

            return temp;
        }

        public void reverseDI() {
            int li = 0;
            int ri = size -1;

            while (li < ri) {
                Node left = getNodeAt((li));
                Node right = getNodeAt((ri));

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }



    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Displaying the elements in the linked list
        list.display();  // Output: 10 20 30
        list.size();
        list.removeFirst();
        list.display();
        list.getFirst();
        list.getLast();
        list.getAt(1);
        list.addFirst((100));
        list.display();
        list.reverseDI();
        list.display();
    }

}

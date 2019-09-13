package com.problem.solving.ds.list.problem;

/**
 * https://www.geeksforgeeks.org/rotate-a-linked-list/
 */
public class RotateLinkedList {

    int k = 4;

    LinkedList linkedList;

    public static void main(String[] args) {

        RotateLinkedList problem = new RotateLinkedList();
        problem.createLinkedList();
    }

    private void createLinkedList() {
        Node n10 = new Node(10);
        Node n20 = new Node(20);
        Node n30 = new Node(30);
        Node n40 = new Node(40);
        Node n50 = new Node(50);
        Node n60 = new Node(60);

        n10.next = n20;
        n20.next = n30;
        n30.next = n40;
        n40.next = n50;
        n50.next = n60;

        linkedList = new LinkedList(n10);
        linkedList.printList();

        linkedList.rotateByK(4);
        linkedList.printList();
    }


    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    class LinkedList {
        Node head;

        public LinkedList(Node head) {
            this.head = head;
        }

        public void printList() {
            Node temp = head;
            System.out.println();
            System.out.print(" head");
            while (temp != null) {
                System.out.println(" ->" + temp.key);
                temp = temp.next;
            }
        }

        public void rotateByK(int k) {
            if (head == null) {
                return;
            }
            System.out.println("--rotate linked list by K---");
            int count = 1;
            Node temp = head;

            while (temp != null && count < k) {
                count++;
                temp = temp.next;
            }

            if(temp==null){
                return;
            }
            //temp is  node which should be first now
           // head = temp;
            Node kthNode= temp;
            //got ot last noe
            while (temp.next != null) {
                temp = temp.next;
            }
            //temp is now last node
            temp.next = head;

            head= kthNode.next;
            // change next of kth node to null
            kthNode.next = null;


        }


    }
}

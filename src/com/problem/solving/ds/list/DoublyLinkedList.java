package com.problem.solving.ds.list;

/**
 * https://www.geeksforgeeks.org/doubly-linked-list/
 * A Doubly Linked List (DLL) contains an extra pointer, typically called previous pointer,
 * together with next pointer and data which are there in singly linked list.
 * Following are advantages/disadvantages of doubly linked list over singly linked list.
 * Advantages over singly linked list
 * 1) A DLL can be traversed in both forward and backward direction.
 * 2) The delete operation in DLL is more efficient if pointer to the node to be deleted is given.
 * 3) We can quickly insert a new node before a given node.
 * In singly linked list, to delete a node, pointer to the previous node is needed. To get this previous node, sometimes the list is traversed. In DLL, we can get the previous node using previous pointer.
 * Disadvantages over singly linked list
 * 1) Every node of DLL Require extra space for an previous pointer. It is possible to implement DLL with single pointer though (See this and this).
 * 2) All operations require an extra pointer previous to be maintained. For example, in insertion, we need to modify previous pointers together with next pointers. For example in following functions for insertions at different positions, we need 1 or 2 extra steps to set previous pointer.
 * Insertion
 * A node can be added in four ways
 * 1) At the front of the DLL
 * 2) After a given node.
 * 3) At the end of the DLL
 * 4) Before a given node.
 */
public class DoublyLinkedList {
    DLNode head = null;
    static DLNode n2 = new DLNode(2);

    public static void main(String[] args) {


        DoublyLinkedList dll = new DoublyLinkedList();
        dll.push(new DLNode(1));
        dll.push(n2);
        dll.push(new DLNode(3));
        dll.push(new DLNode(4));
        dll.print();
        dll.insertAfter(n2, new DLNode(5));
        dll.append(new DLNode(6));
        dll.print();
        dll.insertBefore(n2, new DLNode(7));
        dll.print();
        dll.deleteNode(n2);
        dll.print();
    }


    /*
    insert at head
    O(1)
     */
    private void push(DLNode node) {
        if (isEmpty()) {
            this.head = node;
            return;
        }

        DLNode temp = head;
        temp.prev = node;
        node.next = temp;
        node.prev = null;
        head = node;


    }

    private void insertAfter(DLNode prevNode, DLNode newNode) {
        if (isEmpty()) {
            return;
        }

        DLNode temp = head;

        while (temp != null) {
            if (temp.key == prevNode.key) {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next = newNode;
                break;
            }
            temp = temp.next;

        }

    }

    private void insertBefore(DLNode nextNode, DLNode newNode) {
        if (isEmpty()) {
            return;
        }

        DLNode temp = head;

        while (temp != null) {
            if (temp.key == nextNode.key) {
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;

                break;
            }
            temp = temp.next;

        }

    }

    private void append(DLNode node) {

        if (isEmpty()) {
            this.head = node;
            return;
        }

        DLNode temp = head;

        while (temp.next != null) {
            //traverse till last node
            temp = temp.next;
        }
        node.prev = temp;
        temp.next = node;


    }

    private void deleteNode(DLNode node) {
        if (isEmpty()) {
            return;
        }

        if (head.key == node.key) {
            head = null;
        }

        DLNode temp = head;
        while (temp != null) {

            if (temp.key == node.key) {
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                break;
            }
            temp=temp.next;
        }
    }

    private void print() {
        if (isEmpty()) {
            return;
        }
        System.out.println();
        DLNode node = head;
        while (node != null) {
            System.out.print(" " + node.key + " ");
            node = node.next;
        }


    }

    private boolean isEmpty() {
        if (head == null) {
            System.out.println("UnderFlow");
            return true;
        } else {
            return false;
        }

    }


}

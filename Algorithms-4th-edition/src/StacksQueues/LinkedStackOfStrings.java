package StacksQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Author: Gregorio Vazquez

Stack -> LIFO last in first out
Value: collection of objects
Operations: insert, remove, iterate, test if empty

Every operation takes constant time in the worst case

A stack with N items uses ~ 40N bytes
Object overhead -> 16bytes
extra overhead -> 8 bytes
item -> 8 bytes
next -> 8 bytes

Remark. Analysis includes memory for the stack (but not the strings themselves, witch the client owns)
*/

// Linked list implementation
public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    // insert a new string onto stack
    void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    //remove and return the string most recently added
    String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    //is the stack empty?
    boolean isEmpty() {
        return first == null;
    }

    // Optional: number of strings on the stack
    int size() {
        int count = 0;
        Node temp = first;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        // Enter of the txt
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop());
            } else {
                stack.push(s);
            }
        }
        /*
            Data:
            to be or not to - be - - that - - - is
        */
    }
}

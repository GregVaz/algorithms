package StacksQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Author: Gregorio Vazquez

Queue -> FIFO first in first out
Value: collection of objects
Operations: insert, remove, iterate, test if empty

*/

// Linked list implementation
public class LinkedQueueOfStrings {
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    // insert a new string onto stack
    void enqueue(String item) {
        Node oldLast = last;
        last  = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    //remove and return the string most recently added
    String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
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
        LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
        // Enter of the txt
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(queue.dequeue());
            } else {
                queue.enqueue(s);
            }
        }
        /*
            Data:
            to be or not to - be - - that - - - is
        */
    }
}

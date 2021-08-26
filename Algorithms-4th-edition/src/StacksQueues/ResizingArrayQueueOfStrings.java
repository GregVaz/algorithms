package StacksQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Author: Gregorio Vazquez

Queue -> FIFO first in first out
Value: collection of objects
Operations: insert, remove, iterate, test if empty

-> resizing-array implementation => repeated doubling
*/

// array implementation
public class ResizingArrayQueueOfStrings {
    private String[] s;
    private int head = 0, tail = 0;

    ResizingArrayQueueOfStrings() {
        s = new String[1];
    }

    //insert a new string onto stack
    void enqueue(String item) {
        if (tail == s.length) {
            resize(2 * s.length);
        }
        s[tail++] = item;
    }

    //remove and return the string most recently added
    // How to shrink array? halve size of array s[] when array is one-quarter full
    String dequeue() {
        String item = s[head];
        s[head++] = null;
        if (head > 0 && (head - tail) == s.length/4) {
            resize(s.length/2);
            tail = head - tail;
            head = 0;
        }
        return item;
        //array is between 25% and 100% full
    }

    //is the stack empty?
    boolean isEmpty() {
        return head == tail;
    }

    // Optional: number of strings on the stack
    int size() {
        return head - tail;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        int newS = head - tail;
        for (int i = 0; i < newS; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
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

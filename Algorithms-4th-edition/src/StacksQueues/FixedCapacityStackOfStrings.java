package StacksQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Author: Gregorio Vazquez

Stack -> LIFO last in first out
Value: collection of objects
Operations: insert, remove, iterate, test if empty

Stack considerations
Underflow: throw exception if pop from an empty stack
Overflow: use resizing array for array implementation
Null items: We allow null items to be inserted.
Loitering: Holding a reference to an object when it is no longer needed.
*/

// array implementation
public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    // insert a new string onto stack
    void push(String item) {
        s[N++] = item;
    }

    //remove and return the string most recently added
    String pop() {
        return s[--N];
        // lotering
        /*
            String item = s[--N];
            s[N] = null;
            return item;
            // efficient use of memory
        */
    }

    //is the stack empty?
    boolean isEmpty() {
        return N == 0;
    }

    // Optional: number of strings on the stack
    int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
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

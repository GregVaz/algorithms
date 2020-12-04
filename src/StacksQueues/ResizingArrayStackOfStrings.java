package StacksQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Author: Gregorio Vazquez

Stack -> LIFO last in first out
Value: collection of objects
Operations: insert, remove, iterate, test if empty

-> resizing-array implementation => repeated doubling
*/

// array implementation
public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    //insert a new string onto stack
    //Cost of inserting first N items = N + (2 + 4 + 8 + ... + N) ~ 3N
    void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    //remove and return the string most recently added
    // How to shrink array? halve size of array s[] when array is one-quarter full
    String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }
        return item;
        //array is between 25% and 100% full
    }

    //is the stack empty?
    boolean isEmpty() {
        return N == 0;
    }

    // Optional: number of strings on the stack
    int size() {
        return N;
    }


    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
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

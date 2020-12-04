package StacksQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Author: Gregorio Vazquez
*/

// array implementation
public class FixedCapacityGenericStack<Item> {
    private Item[] s;
    private int N = 0;

    FixedCapacityGenericStack(int capacity) {
        // unchecked cast
        s = (Item[]) new Object[capacity];
    }

    // insert a new string onto stack
    void push(Item item) {
        s[N++] = item;
    }

    //remove and return the string most recently added
    Item pop() {
        return s[--N];
    }

    //is the stack empty?
    boolean isEmpty() {
        return N == 0;
    }


    public static void main(String[] args) {
        FixedCapacityGenericStack stack = new FixedCapacityGenericStack(10);
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

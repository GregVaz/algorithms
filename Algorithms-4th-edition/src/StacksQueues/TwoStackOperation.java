package StacksQueues;


/*
Dijkstra's two-stack algorithm
value -> push onto the value stack
Operator -> push onto the operator stack
left parenthesis -> ignore
right parenthesis -> pop operator and two values; push the result of applying that operator to those onto the operand stack
*/


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class TwoStackOperation {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("))          ;
            else if (s.equals("+"))     ops.push(s);
            else if (s.equals("*"))     ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+"))         vals.push(vals.pop() + vals.pop());
                else if (op.equals("*"))    vals.push(vals.pop() * vals.pop());
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.print(vals.pop());
    }
}

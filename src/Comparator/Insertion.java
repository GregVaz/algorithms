package Comparator;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

//Insertion sort using comparator
public class Insertion {
    public static final Comparator<Object> BY_STR = new ASC();
    public static void sort(Object[] a, Comparator comparator) {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0; j--)
                if (less(comparator, a[j], a[j-1]))
                    exch(a, j, j-1);
                else break;
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v,w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static class ASC implements Comparator<Object> {
        public int compare(Object v, Object w) {
            return v.toString().compareTo(w.toString());
        }
    }

    public static void main(String[] args) {
        String[] ex = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        for (int i = 0; i < ex.length; i++)
            StdOut.print(ex[i] + " ");
        StdOut.println("");
        sort(ex, BY_STR);
        for (int i = 0; i < ex.length; i++)
            StdOut.print(ex[i] + " ");
    }
}

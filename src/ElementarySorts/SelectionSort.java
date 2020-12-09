package ElementarySorts;

/*
    In iteration, find index min of smallest remaining entry
    Swap a[i] and a [min]
*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;

public class SelectionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        // real numbers
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        sort(a);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);

        // String
        String[] s = StdIn.readAllStrings();
        sort(s);
        for (int i = 0; i < s.length; i++)
            StdOut.println(s[i]);

        // Files
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        sort(files);
        for (int i = 0; i < files.length; i++)
            StdOut.println(files[i]);
        */

        String[] ex = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(ex);
        for (int i = 0; i < ex.length; i++)
            StdOut.println(ex[i]);
    }
}

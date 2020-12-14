package Mergesort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // Create a copy of the array
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // Compare, pass and fix
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++){
            // Just insert all the left elements on j idx
            if(i > mid)
                a[k] = aux[j++];
            // Just insert all the left elements on i idx
            else if(j > hi)
                a[k] = aux[i++];
            // Simples compares between tiny arrays and put on the original array
            else if(less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = (lo + 1); i < hi; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // Base case
        if( hi <= lo )
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void printArray(Comparable[] a) {
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i]);
        StdOut.println("");
    }

    public static void main(String[] args) {
        String[] ex = "M E R G E S O R T E E X A M P L E".split(" ");
        printArray(ex);
        sort(ex);
        printArray(ex);
    }

    /*
    /*
            a.length    = 10
            aux.length  = 10
            lo = 0
            hi = 9
            mid = 4
            sort(a, aux, 0, 4)
                lo = 0
                hi = 4
                mid = 2
                sort(a, aux, 0, 2)
                    lo = 0
                    hi = 2
                    mid = 1
                    sort(a, aux, 0, 1)
                        lo = 0
                        hi = 1
                        mid = 0
                        sort(a, aux, 0, 0)
                            return;
                        sort(a, aux, 0, 0)
                            return;
                        merge(a, aux, 0, 0, 0)
                            return;
                    sort(a, aux, 1, 2)
                    merge(a, aux, 0, 2, 4)
                sort(a, aux, 2, 4)
                merge(a, aux, 0, 2, 4)
            sort(a, aux, 5, 9)
            merge(a, aux, 0, 4, 9)
     */
}

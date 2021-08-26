package Mergesort;


import edu.princeton.cs.algs4.StdOut;

// Merge sort bottom-up, you do not use recursion
public class MergeBU {
    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
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

    public static void printArray(Comparable[] a) {
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i]);
        StdOut.println("");
    }


    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)            // 1, 2, 4, 8
            for (int lo = 0; lo < N-sz; lo += sz+sz)    // 0, 2, 4, 8
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1)); //(a,0,0,1), (a,2,2,3), (a,4,4,5)
    }

    public static void main(String[] args) {
        String[] ex = "M E R G E S O R T E E X A M P L E".split(" ");
        printArray(ex);
        sort(ex);
        printArray(ex);
    }

}

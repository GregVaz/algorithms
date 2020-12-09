package ElementarySorts;

/*
Always takes quadratic time
You ise a increment sequence
Which increment sequence to use?
    Powers of two -> no
    Powers of two - 1 -> Maybe
    3x + 1 -> OK (Easy to compute)
    Sedgewick -> 1,5,19,41,109,209,505,929,2161,3905,...  -> Good (though to beat in empirical studies)
*/

import edu.princeton.cs.algs4.StdOut;

public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1,4,13,40,121,364,... -> 3x + 1
//        StdOut.println("Sequence: " + h);
        while(h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }

            h = h/3;
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

    public static void main(String[] args) {
        String[] ex = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(ex);
        for (int i = 0; i < ex.length; i++)
            StdOut.println(ex[i]);
    }

}

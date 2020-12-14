package ElementarySorts;

/*
Shuffle sort
    Generate a random real number for each array entry
    Sort the array

    Knuth shuffle
        In iteration i, [ick integer r between 0 and i uniformly at random
        Swap a[i] and a[r]
        -> [Fisher-Yates 1938] Knuth shuffle algorithm produces a uniformly
            random permutation of the input array in linear time
*/

import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {

    public static void shuffle(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // common bug: between 0 and N - 1
            // correct variant: between i and N - 1
            int r = StdRandom.uniform(i+1);
            exch(a, i, r);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

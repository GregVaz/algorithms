package PriorityQueue;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    // No generic array creation
    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public Key delMax() {
        int max = 0;
        // found the index of the max item
        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        // exchange with the last in the array
        exch(max, N-1);
        // return the last item
        return pq[--N];
    }
}

package QU;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gregorio Vazquez
 */
public class WeightedQuickUnion {
    int []id;
    int []sz;
    
    public WeightedQuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }
    
    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // Path compression
            i = id[i];
        }
        return i;
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
    public void union(int p, int q) {
        int pr = root(p);
        int qr = root(q);
        if (pr == qr) {
            return;
        }
        if (sz[pr] < sz[qr]) {
            id[pr] = qr;
            sz[qr] += sz[pr];
        } else {
            id[qr] = pr;
            sz[pr] += sz[qr];
        }
    }
    
    public void printData() {
        System.out.print('[');
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println(']');
    }
    
    public static void main(String[] args) {
        WeightedQuickUnion qu = new WeightedQuickUnion(10);
        qu.printData();
        qu.union(0, 2);
        qu.union(3, 2);
        qu.union(5, 2);
        qu.printData();
        System.out.println(qu.connected(5,2));
        System.out.println(qu.connected(1,2));
    }
}

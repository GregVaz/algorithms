package QU;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gregorio Vazquez
 */
public class QuickFind {
    int []id;
    
    public QuickFind(int N){
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }
    
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
    
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
    
    public void printData() {
        System.out.print('[');
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.print(']');
    }
    
    public static void main(String[] args) {
        QuickFind qf = new QuickFind(6);
        qf.printData();
        qf.union(0, 2);
        qf.union(3, 2);
        qf.union(5, 2);
        qf.printData();
        System.out.println(qf.connected(5,2));
        System.out.println(qf.connected(1,2));
    }
}

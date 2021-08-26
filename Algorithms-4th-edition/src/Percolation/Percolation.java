package Percolation;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author Gregorio Vazquez
 */
public class Percolation {
    private int [][]grid;
    private int openGrid;
    private int size;
    private WeightedQuickUnionUF wQU;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new int[n][n];
        wQU = new WeightedQuickUnionUF((n*n)+2);
        openGrid = 0;
        size = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
                if (i == 0) {
                    wQU.union((n*n), j);
                }
                if (i == n-1) {                
                    wQU.union((n*n)+1, (i*size)+j);
                }
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            grid[row][col] = 1;
            openGrid++;
            int idx = (size * row) + col;
            if (row > 0) {
                // top
                if (isOpen(row-1, col) && wQU.find(idx) != wQU.find(idx-size)) {
                    wQU.union(idx, idx-size);
                }
            }
            if (col < size - 1) {
                // right
                if (isOpen(row, col+1) && wQU.find(idx) != wQU.find(idx+1)) {
                    wQU.union(idx, idx+1);
                }
            }
            if (row < size - 1) {
                //bottom
                if (isOpen(row+1, col) && wQU.find(idx) != wQU.find(idx+size)) {
                    wQU.union(idx, idx+size);
                }
            }
            if (col > 0) {
                //left
                if (isOpen(row, col-1) && wQU.find(idx) != wQU.find(idx-1)) {
                    wQU.union(idx, idx-1);
                }
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row >= grid.length || col >= grid.length) {
            throw new IllegalArgumentException();
        }
        return grid[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row >= grid.length || col >= grid.length) {
            throw new IllegalArgumentException();
        }
        if (percolates()) {
            return wQU.find((size*row) + col) == wQU.find(grid.length + 1);
        } else {
            return false;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openGrid;
    }

    // does the system percolate?
    public boolean percolates() {
        return wQU.find(grid.length + 1) == wQU.find(grid.length + 2);
    }

    // test client (optional)
    public static void main(String[] args) {
//        int s = 200;
//        Percolation p = new Percolation(s);
//        while (!p.percolates()) {
//            int i = StdRandom.uniform(s);
//            int j = StdRandom.uniform(s);
//            p.open(i, j);
//        }
//        System.out.println(p.isFull(0,2));
//        System.out.println(p.isFull(0,4));
//        System.out.println(p.isFull(2,2));
//        System.out.println(p.numberOfOpenSites());
//        System.out.println((double)p.numberOfOpenSites()/(s*s));
    }
}

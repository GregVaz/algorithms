package Percolation;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.lang.Math;

/**
 *
 * @author Gregorio Vazquez
 */
public class PercolationStats {
    private double [] res;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        res = new double[trials];
        int t = 0;
        while (t < trials) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int i = StdRandom.uniform(n);
                int j = StdRandom.uniform(n);
                p.open(i, j);
            }
            res[t] = p.numberOfOpenSites()/Math.pow(n, 2);
            t++;
        }
    }
 
    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(res);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(res);
    }
    
    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96*stddev())/Math.sqrt(res.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96*stddev())/Math.sqrt(res.length));
    }

   // test client (see below)
   public static void main(String[] args) {
        int size = StdIn.readInt();
        int trials = StdIn.readInt();
        PercolationStats ps = new PercolationStats(size, trials);
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
   }

}

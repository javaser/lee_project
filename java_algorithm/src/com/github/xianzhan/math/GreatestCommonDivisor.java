package com.github.xianzhan.math;

public class GreatestCommonDivisor {

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int g = gcd(18, 15);
        System.out.println(g);
    }
}

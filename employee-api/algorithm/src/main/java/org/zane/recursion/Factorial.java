package org.zane.recursion;

public class Factorial {

    public static int calculate(int n) {
        if (n == 1 || n == 0) {
            return n;
        } else {
            return n * calculate(n - 1);
        }
    }
}

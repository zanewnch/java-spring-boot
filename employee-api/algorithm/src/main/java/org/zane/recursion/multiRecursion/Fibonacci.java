package org.zane.recursion.multiRecursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
非波那契数列（Fibonacci sequence）是一个经典的数学数列，其定义如下：

第一个和第二个数字是1：F(1) = 1, F(2) = 1。
从第三个数字开始，每个数字是前两个数字的和：F(n) = F(n-1) + F(n-2)，其中 n > 2。
这个数列的开始如下所示：1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 */
public class Fibonacci {
    /*
    這個method 是計算第n個element的value
     */
    /*
    如果畫圖 這個multi recursion 的計算 會發現類似binary tree
     */
    public static int fibonacciRecursion(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    public static int fibonacciLoop(int n) {
        if (n <= 1) {
            return n;
        } else {
            int[] array = new int[n + 1];
            array[0] = 0;
            array[1] = 1;

            for (int i = 2; i < array.length; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }

            return array[n];
        }
    }

    public class FibonacciRecursionMemoization {
        private Map<Integer, Integer> memo = new HashMap<>();

        public int fibonacci(int n) {
            // Check if the result is already memoized
            if (memo.containsKey(n)) {
                return memo.get(n);
            }

            // Base cases
            if (n <= 1) {
                return n;
            }

            // Recursive calls with memoization
            int result = fibonacci(n - 1) + fibonacci(n - 2);

            // Store the result in the memoization table
            memo.put(n, result);

            return result;
        }

    public static void main(String[] args) {
        int result = fibonacciRecursion(10);
        System.out.println(result);
    }
}

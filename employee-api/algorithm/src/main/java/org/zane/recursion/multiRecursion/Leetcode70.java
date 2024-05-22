package org.zane.recursion.multiRecursion;

public class Leetcode70 {

    /*
    跟recursion最大的不同就是，recursion不會store n之前的value,而是一直開新的method call;
    但到loop這邊，需要先create an array to store the value, 不然沒辦法run for loop.

    如果沒創array:
    for (int i = 0; i < n; i++) {
                int x = 1;
                int y = 2;
                int z = x + y;
            }
    每一次loop都會把x,y,z蓋掉
    新loop就沒辦法用到之前的value
     */

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        /*
        要先創一個array, 然後要把array裡面的element都先計算好
        */
        int[] array = new int[n + 1];
            /*
            要先把array[1]跟array[2]先assign value, 不然run loop的時候 array[3]會是null
             */
        // array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }


    /*
    我用multi recursion去解，他跟我說
    Time Limit Exceeded
    因為recursion太慢了，所以改用loop去解
     */

    public int climbStairsRecursion(int n) {
        // 先列舉 然後發現符合Fibonacci
        // f(0) 雖然應該是0,因為0階沒有上去的方法，但為了計算，f(0) = 1
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
        }
    }


    /*
    這個就很好地表示了 沒讀算法前 我想的是用機率去計算
    讀了算法 知道這是fibonacci sequence之後，一下就解出來了
     */
    // 是錯誤的 只是記錄下解題邏輯
    class Solution {
        public int climbStairs(int n) {
        /*
        偶數都是對的
        奇數要減1


        n = 3
        step = 1
        i = 2
        c(2,1) * (2 ^ 1) = 2 * 2 = 4

        2 1
        11 1
        1 2
        1 11
        如果全部都是1 那就沒有順序先後
        如果全部都是2 那就沒有順序先後

        c(2,2) * 2(2) = 1 * 4 = 4
        4:
        2 2
        11 2
        2 11
        11 11

        step = 3 i = 3
        c(3,3) * 2^ 3 = 1 * 8 = 8
        6: (8)
        2 2 2

        11 2 2
        2 11 2
        2 2 11

        11 11 2
        11 2 11
        2 11 11

        11 11 11


        */

            if (n == 1) {
                return n;
            }


            // java 無條件退位
            int step = n / 2;
            int i;
            if (n % 2 == 0) {
                i = step;
            } else {
                // n % 2 != 0
                i = step + 1;
            }

            // 计算组合数并将结果转换为整数
            int combinations = choose(i, step);

            // 计算 2 的 step 次方
            int powerOf2 = (int) Math.pow(2, step);

            // 返回最终结果
        /*
        猜對了 偶數保持不變
        但奇數需要減1
        但我不知道為什麼奇數需要減1
        我只是根據test result 猜說應該是奇數要減1
        */
            if (n % 2 == 0) {
                return combinations * powerOf2;
            } else {
                return (combinations * powerOf2) - 1;
            }


            // 總數字的計算function
            // n / 2   代表會有幾個2
            // 每一個2 會有 =2 !=2 兩種可能

            // 先後順序是有差的


            // c 總元素 要取的元素
            // c3取2 = 3! / 2!*(1!)

            // 只要計算  所有元素當中  有幾個會是2


            // 先確定總共有幾個數字   然後2有幾個 1有幾個
            // 然後用c去計算

            // 假設 n = 3
            // step = 1
            // 代表總共數字會有1個2


            // n = 5:
            // 2 2 1

            // step = 2
            // i = 3

            // if(n % 2 == 0){
            //     i = step;
            // }else{
            //     // n % 2 != 0
            //     i = step + 1;
            // }


            // (2個個數)
            // c3取2 = 3   每一個2 都可以替換成11  所以* 2

            // C總個數取2個數* (2 ^ 2個數)

            // c(i 取 step) * ( 2 ^ step)
            // c(3 取 2 )* (2 ^ 2)
            // 3 * 4 = 12

            // 2  2  1
            // 11 11 1
            // 2  11 1
            // 11 2  1

            // 2  1  2
            // 11 1  11
            // 2  1  11
            // 11 1  2

            // 1  2  2
            // 1  11 11
            // 1  2  11
            // 1  11  2

            // total: 12
            // --------


            // 2  2  1
            // 11 11 1

            // 2 11 1

            // 11 2 1

            // 2 11  2
            // 11 2 2

        }

        public int factorial(int n) {
            if (n == 1 || n == 0) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        }

        public int choose(int total, int number) {
            if (number > total) {
                return 0; // 处理 number 大于 total 的情况
            }

            // c 3 取 2 = 3! / (2! * (3-2)!)


            return factorial(total) / (factorial(number) * factorial(total - number));
        }
    }
}

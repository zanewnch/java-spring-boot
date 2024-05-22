package org.zane.binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
BinarySearch is 給定一個target, 找出這個target 在array 的index
 */
public class BinarySearchTest {

    /*
    Question:
    In a sorted array, find the index of the target number.

    Input: the target number

    Output: the index of the target number, or return -1 if the target number is not in the array
     */

    /*
    為什麼叫做binary search?
    因為核心做法就是先set two pointer, 所以是binary 二分

    如果是直接用loop to traverse, 那就是linear 線性
    */

    /*
    i and j 最終一定會meet or j < i
     */

    // 這個最重要 學這個
    public int BinarySearch(int target, int[] array) {

        /*
        這是基礎版，以此為主

    solution with nature language:
    先設置兩個pointer, 分別指向array 的兩端, 當 i < j or i = j, 就執行while loop裡面的logic; 當 i > j的時候就會跳出loop, 並且return -1(也就是target不在array裡面的情況).
    然後在設置一個pointer m指向i and j 的中間數，然後因為m 是每次i or j reset renew 的時候都要重新計算, 所以應該在loop 當中 declare m.
    有了m 之後, 比較 target and array[m], 如果 target > array[m], 那應該要找array靠近右側的數字，所以i = m+1; 如果 target < array[m], 那應該要找array靠近左側的數字，所以j = m-1; 如果 target == array[m], 那就代表找到答案了，直接return m;
    至於為什麼是m+1 and m-1, 是因為比對的是array[m], 確定大小後就把pointer移向m 的左或右一個數字再繼續比對

     */

    /*
    1.
    這邊有一個細節： m = (i + j) >>> 1; 這邊的 >>> 1 是什麼意思？
    這邊的 >>> 1 是指將 m = (i + j) / 2; 這個除法換成右移一位, 至於為什麼要右移一位，是因為java int 的二進制當中，最左一位是符號位，如果是1代表負數，如果是0代表正數，所以如果是負數的話，右移一位會變成正數，這樣就可以避免overflow的問題
    然後因為在二進制的情況下，如果右移一位，剛好數字就等於除2, 所以才會寫成 m = (i + j) >>> 1;
     */

    /*
    2.
    當i = j, 那就會發生 i = j = m, 也就代表 i and j 會參與comparison
    也就是i and j 分別為左閉跟右閉，兩邊會參與比較，也就代表while(i <= j) 裡面需要 i = j的condition
     */

        int i = 0; // left
        int j = array.length - 1; // right, 因為要的是index, 所以要減1 (array,length is return the number of elements)



        /*
        i < j代表有中間element, if i = j, 代表element 只剩一個, 也就是i = j = m, 此時要判斷這個element是不是target, 如果是就return i, 如果不是就return -1
         */
        while (i <= j) {

            // int m = (i + j) / 2; // mid
            int m = (i + j) >>> 1; // mid

            /*
            這個while loop 執行次數是L次
            然後當target < all element in array, 只需要run if statement 的第一句，所以runtime is L
            但是當target > all element in array, 還需要run if statement 的第二句, 所以runtime is 2*L
             */
            if (target > array[m]) {
                i = m + 1; // target > midValue, 代表答案在靠近右邊，所以i would equal to m + 1
            } else if (target < array[m]) {
                j = m - 1; // target < midValue, 代表答案在靠近左邊，所以j would equal to m - 1
            } else {
                // target == midValue, 代表找到答案, 此時i = j = m,也代表只剩一個element, so then return m

                /*
                我知道我的盲點了，我那時候想if target is not in array, 也就是 target != array[m] 該怎麼辦，
                但其實 target != array[m] 細分的話就只有 > or <, 然後這個while loop 會一直run到i = j, 此時只剩下一個元素, 然後僅存元素還不等於target, 就會產生 i > j, 這時候就會跳出while loop, 然後return -1
                 */
                return m;

            }
        }

        return -1;

    }

    /*
    recursion principle:
    1. traverse variable with end point to be the method parameter

    in this case, the mutable variable is i and j.
     */
    public int binarySearchRecursion(int[] array, int target, int i , int j) {
        if(i <= j){
            int m = (i + j) >>> 1;

            if(target > array[m]){
//                i = m + 1;
                return binarySearchRecursion(array,target,m+1,j);
            }else if(target < array[m]) {
//                j = m - 1;
                return binarySearchRecursion(array, target,i ,m-1);
            }else{
                return m;
            }
        }
        return -1;
    }

    // 找minimum 重要
    public int binarySearchMinimum(int[] array, int target) {
        /*
        introduction:
        this algorithm just address if target in array, return the minimum index; and if target is not in array, reuturn -1
         */

        int i = 0;
        int j = array.length - 1;
        int temp = -1; // default failure value

        while (i <= j) {

            int m = (i + j) >>> 1;

            if (target < array[m]) {
                j = m - 1;
            } else if (target > array[m]) {
                i = m + 1;
            } else {
                // target == array[m]
                // record the temporary result
                temp = m;

                // keep searching towards the left to find the minimum index
                j = m - 1;

                // when j < i, the loop would break out
            }

        }
        /*
        如果一直沒找到target, 那m 就不會被re-assign, so return temp would be return -1
         */
        return temp;
    }

    // 找 maximum 重要
    public int binarySearchMaximum(int[] array, int target) {

        int i = 0;
        int j = array.length - 1;
        int temp = -1; // default failure value

        while (i <= j) {

            int m = (i + j) >>> 1;

            if (target < array[m]) {
                j = m - 1;
            } else if (target > array[m]) {
                i = m + 1;
            } else {
                // target == array[m]
                // record the temporary result
                temp = m;

                // keep searching towards the right to find the maximum index
                i = m + 1;


                // when j < i, the loop would break out
            }


        }
        return temp;
    }

    // 這個不用學
    /*
    進階的binarySearch
    i and j 是左閉右開，也就是j 不參與comparison, 也就代表while loop 不包含 i=j condition;
     因為只有i = j && i = j = m condition i and j 才會參與comparison
     */
    public int binarySearchAdvanced(int target, int[] array) {

        int i = 0; // left
        int j = array.length; // right

        while (i < j) {
            /*
                if i <= j;
                當target not in array, 就會陷入 target < array[m] 的 infinite loop
                 */

            int m = (i + j) >>> 1; // mid

            if (target < array[m]) {
                /*
                j 是右開 不參與comparison, 所以j = m
                if j = m + 1; 那就會參與comparison
                 */
                j = m;

            } else if (target > array[m]) {

                i = m + 1;

            } else {

                // target == array[m]
                return m;
            }
        }

        return -1;

    }

    // 這個不用學
    public int binarySearchAdvancedBalanced(int[] array, int target) {

        int i = 0; // left
        int j = array.length; // right

        /*
        這個版本減少了一次 else if judgement
        因為多一個judgement 就等於runtime 多一倍（suppose target > all element in array）

        然後找比較小的數字跟找比較大的數字，所花費的runtime一樣，所以是balanced edition

        然後這個版本變成要跳出loop 才會判斷target == array[i]
         */

        /*
        為什麼不寫 j > i ?
        both approach are have the same time and space complexity,
        but 1 < j - i is more readable
         */
        while (1 < j - i) {
            int m = (i + j) >>> 1; // mid

            if (target < array[m]) {
                j = m;
            } else {
                i = m;
            }
        }

        //        if (array[i] == target) {
        //            return i;
        //        } else {
        //            return -1;
        //        }
        return array[i] == target ? i : -1;
    }

    /*
    another question:
    if target in array, return the minimum index, but if not in array, return the index target should be inserted

    above algorithm is the solution:
     */
    public int binarySearchMinimumAdvanced(int[] array, int target) {
        /*
        introduction:
        the advanced edition, if target in array return minimum index, but if not in array, this algorithm would return the index target should be inserted.
         */

        int i = 0;
        int j = array.length - 1;


        while (i <= j) {

            int m = (i + j) >>> 1;

            if (target <= array[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }

        }
        /*
        如果成功找到, i would = target index
        如果target not in array, i would be 比target大一階, 然後最小(左)的index

        上一個part 的logic is create temp = m and keep searching, 但當這一part 的時候是直接return i, 所以不需要temp, 然後再把 j = m - 1 進行合併

        可是問題就會變成不知道target whether in array:
        當面對到題目是問：if target in array return index, if not then return the index target should be inserted, 而剛好 比target大一階, 然後最小(左)的index 就是target should be inserted 的index, 所以可以直接return i
         */
        return i;
    }


    public int binarySearchMaximumAdvanced(int[] array, int target) {

        int i = 0;
        int j = array.length - 1;
        int temp = -1; // default failure value

        while (i <= j) {

            int m = (i + j) >>> 1;

            if (target < array[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }

        }

        /*
        如果成功找到, i + 1 = j = target index
        如果target not in array, i + 1 would be 比target小一階, 然後最大(右)的index

        可是問題就會變成不知道target whether in array
         */
        return i + 1;
    }


    @Test
    public void test() {
        int[] array = {10, 20, 30, 40, 50, 60, 70};

        /*
        The logic of assetEquals is: assertEquals(expected, actual)
         */
        assertEquals(0, BinarySearch(10, array));
        assertEquals(1, BinarySearch(20, array));
        assertEquals(2, BinarySearch(30, array));
        assertEquals(3, BinarySearch(40, array));
        assertEquals(4, BinarySearch(50, array));
        assertEquals(5, BinarySearch(60, array));
        assertEquals(6, BinarySearch(70, array));
        assertEquals(-1, BinarySearch(80, array));
    }


}

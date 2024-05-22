package org.zane.sort;

import java.lang.annotation.Target;
import java.util.Arrays;

public class InsertionSort {

    /*
    邏輯：
    從未排序區選left bound value, 然後traverse已排序區做比較，每一個大於target的都往右移，直到找到小於target的element,然後把target插在這個element的右邊
     */
    public static void insertionSort(int[] array) {

        /*
        這個for loop 是從未排序區開始traverse
        然後因為第一個element 可以當作已排序的數字，
        所以loop 從 i = 1 開始
         */
        for (int i = 1; i < array.length; i++) {
            /*
            有說loop 是從未排序區開始traverse,
            所以i 會是未排序區的left bound
            temp 是 store the left bound value,
            用來跟排序區element做比較以及assign value
             */
            int temp = array[i];
            /*
            insertion 的排序區是從array head開始，
            然後比較是在排序區從右至左開始跟temp比較
            因為i 是未排序區的left bound,
            left bound - 1 就是排序區的第一個element
             */
            int j = i - 1;

            /*
            這個while loop的用意:
            1.j會變成第一個小於temp的element index,然後把temp insert to (j+1)
            2.是把排序區大於temp的element往右移

            假設while loop 有執行，那第一次loop 的 array[j+ 1] 的元素值會消失（直接被array[j]覆蓋）,所以才需要用temp 來store 第一次array[j+1]的值
            然後這個while loop 會把已排序區全部traverse一遍
             */
            while (j >= 0 && array[j] > temp) {
                /*
                如果排序區element > target,
                那就把排序區element 往右移
                然後繼續跟排序區下一個element做比較
                 */
                array[j + 1] = array[j];
                /*
                因為排序區是從右至左traverse, 所以j 是 j - 1
                 */
                j--;
            }

            // when while loop break out, the j is the index of the element which is smaller than target
            // 當while loop break out的時候, 代表array[j] < temp, j 是小於target 的index, 所以要在j + 1 插入target

            // 然後原本j 的j+1, 他的value 已經被右移了，所以可以直接assign
            // 至於原本的i,因為假設已排序區有大於target的element,那原本的i就會被覆蓋,然後再把target insert to 已排序區(j+1)

            // 如果已排序區都沒有比target還大的值,那target就應該保留在原位（不會進入while loop, 所以j 依然會是 i - 1）
            // 既然要保留原位，那就代表根本不需要移動;所以加一個if condition, 如果有進while loop(also mean array[j] > temp
            // && mean j has changed), 才需要做insert temp to array[j+1]
            if (j + 1 != i) {
                array[j + 1] = temp;
            }

        }

    }

    public static void insertionSortPractice(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > target) {
                array[j + 1] = array[j];
                j--;
            }

            if (j + 1 != i) {
                array[j + 1] = target;
            }
        }
    }

    /*
    The parameter of start is the left bound of unsorted area
    and the initial value of start should be 1
     */
    public static void insertionSortRecursion(int[] array, int start) {
        if (start == array.length) {
            return;
        }
        int target = array[start];
        int j = start - 1;

        while (j >= 0 && array[j] > target) {
            array[j + 1] = array[j];
            j--;
        }

        array[j + 1] = target;

        insertionSortRecursion(array, start + 1);
    }

    public static void main(String[] args) {
        int[] array = {5, 6, 2, 6, 1, 3};
        insertionSort(array);
        int[] array1 = {5, 6, 2, 6, 1, 3};
        insertionSortRecursion(array1, 1);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
    }
}

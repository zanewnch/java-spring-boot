package org.zane.sort;

import java.util.Arrays;

/*
bubble sort 是做ascending or descending sort
 */

/*
外部循环 for (int i = 0; i < array.length - 1; i++) 遍历整个数组，每一轮迭代都将最大的元素移动到正确的位置。外部循环控制了总共需要执行多少轮排序，因为在每一轮排序后，最大的元素已经移动到了正确的位置，所以不需要再比较它。

内部循环 for (int j = 0; j < array.length - 1 - i; j++) 是内部的冒泡过程，它比较相邻的两个元素，如果前一个元素大于后一个元素，则交换它们的位置。内部循环从数组的开始处一直遍历到未排序部分的末尾，逐渐将最大的元素“冒泡”到未排序部分的末尾。

swapped 变量用于优化算法。在每一轮内部循环中，如果没有进行实际的交换操作，就说明数组已经有序，那么 swapped 保持为 false，并且在外部循环结束后，通过检查 if (!swapped)，可以提前结束排序。

排序完成后，返回排序后的数组。
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        // array.length 要 -1, 因為最後一個元素不需要比較
        // 這個邏輯是重複traverse
        for (int i = 0; i < array.length - 1; i++) {
            /*
            這個swapped 是用來優化算法
            如果inner loop 沒有實際操作, 那swapped 就不會被re-assign to true, 也就代表排序完了，
            那就會直接break outer loop
             */
            boolean swapped = false;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return array;
    }

    /*
    The value of j would be array.length - 1
     */
    public static int[] bubbleSortRecursion(int[] array, int j) {

        if(j == 0){
            return array;
        }

        boolean swapped = false;

        /*
        因為原始edition need to layer of loop, and the recursion only can convert the outer loop; there is still need the inner loop to swap the element.
         */

        for (int i = 0; i < j; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;

                // 用來優化  提前結束
                swapped = true;
            }
        }

        // swapped = false 代表沒有排序已經完成 所以直接return array, 這就跟outer loop 直接break 是一樣的
        if(!swapped){
            return array;
        }

        // recursion replaces the outer loop
        return bubbleSortRecursion(array,j-1);
    }

    // 第二个示例，即bubbleSortRecursion2 方法，使用了 x 变量来记录最后一次交换的位置，然后将该位置传递给递归调用。这种写法在逻辑上也是有效的，但相对来说可能不太直观，需要更多的变量来维护状态。
    //
    //综合考虑可读性和一般的编程约定，第一个示例更容易被其他程序员理解，并且更符合通常的Bubble Sort递归版本的实现方式。因此，如果没有特殊原因，建议使用第一个示例。
    public static int[] bubbleSortRecursion2(int[] array, int j) {

        if(j == 0){
            return array;
        }

        int x = 0;

        for (int i = 0; i < j; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                x = i;
            }
        }

        // recursion replaces the outer loop
        return bubbleSortRecursion2(array,x);
    }



    public static void main(String[] args) {
        int[] array = new int[]{10, 5, 2, 30,55,23,20,66};
        System.out.println("The original array :" + Arrays.toString(array));

        int[] array1 = bubbleSort(array);
        System.out.println("basic bubble sort :" + Arrays.toString(array1));

        int[] arrayy = new int[]{10, 5, 2, 30,55,23,20,66};


        int[] array2 = bubbleSortRecursion(arrayy, arrayy.length -1);
        System.out.println("bubble sort recursion :" + Arrays.toString(array2));
    }
}

package org.zane.binarySearch;

public class leetcode35 {
    /*
    Search Insert Position

    question:
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.
     */

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int m = (i + j) >>> 1;

            if(target <= nums[m]){
                j = m - 1;
            }else{
                i = m + 1;
            }
        }

        return i;
    }
}

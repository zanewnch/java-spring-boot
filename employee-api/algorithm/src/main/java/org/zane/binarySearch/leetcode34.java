package org.zane.binarySearch;

public class leetcode34 {
    /*
    Find First and Last Position of Element in Sorted Array

    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.
     */

    public int[] searchRange(int[] nums, int target) {
        int minimum = searchMinimum(nums,target);

        if(minimum == -1){
            return new int[]{-1,-1};
        }else{
            int maximum = searchMaximum(nums,target);
            return new int[]{minimum,maximum};
        }
    }

    public int searchMinimum(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        int temp = -1;

        while(i <= j){
            int m = (i+j) >>> 1;

            if(target < nums[m]){
                j = m -1;
            }else if(target > nums[m]){
                i = m + 1;
            }else{
                temp = m;
                j = m - 1;
            }
        }

        return temp;
    }

    public int searchMaximum(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        int temp = -1;

        while(i <= j){
            int m = (i+j) >>> 1;

            if(target < nums[m]){
                j = m -1;
            }else if(target > nums[m]){
                i = m + 1;
            }else{
                temp = m;
                i = m + 1;
            }
        }

        return temp;
    }
}

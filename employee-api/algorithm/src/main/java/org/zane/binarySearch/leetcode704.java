package org.zane.binarySearch;

public class leetcode704 {

    /*
    Binary Search

    question:
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.

     */
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {

            int m = (i + j) >>> 1;

            if (target < nums[m]) {
                j = m - 1;
            } else if (target > nums[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}

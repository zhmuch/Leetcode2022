package com.example.kotlinplayground.google

import kotlin.math.E

/**
 * 034 Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
class FirstAndLastPosition {

    /**
     * Solution 1.
     *
     * Traverse all ints in the [nums], find the first and last occurrence of the target.
     * O[n]
     */

    /**
     * Solution 2.
     *
     * Binary search
     */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val size = nums.size
        return intArrayOf(
            searchFirstPosition(nums, target, 0, size - 1),
            searchLastPosition(nums, target, 0, size - 1)
        )
    }

    private fun searchFirstPosition(nums: IntArray, target: Int, startIndex: Int, endIndex: Int): Int {
        // Termination
        if (startIndex > endIndex) {
            return -1
        }
        // Termination
        if (startIndex == endIndex) {
            return if (target == nums[startIndex]) {
                startIndex
            } else {
                -1
            }
        }

        val pivot = (startIndex + endIndex) / 2
        return if (nums[pivot] < target) {
            searchFirstPosition(nums, target, pivot + 1, endIndex)
        } else {
            searchFirstPosition(nums, target, startIndex, pivot)
        }
    }

    private fun searchLastPosition(nums: IntArray, target: Int, startIndex: Int, endIndex: Int): Int {
        // Termination
        if (startIndex > endIndex) {
            return -1
        }
        if (startIndex == endIndex) {
            return if (target == nums[endIndex]) {
                endIndex
            } else {
                -1
            }
        }

        val pivot = (startIndex + endIndex) / 2 + 1         // Make mid biased to the right
        return if (nums[pivot] > target) {
            searchLastPosition(nums, target, startIndex, pivot - 1)
        } else {
            searchLastPosition(nums, target, pivot, endIndex)
        }
    }

    /**
     * Clean solution
     */
//    vector<int> searchRange(int A[], int n, int target) {
//        int i = 0, j = n - 1;
//        vector<int> ret(2, -1);
//        // Search for the left one
//        while (i < j)
//        {
//            int mid = (i + j) /2;
//            if (A[mid] < target) i = mid + 1;
//            else j = mid;
//        }
//        if (A[i]!=target) return ret;
//        else ret[0] = i;
//
//        // Search for the right one
//        j = n-1;  // We don't have to set i to 0 the second time.
//        while (i < j)
//        {
//            int mid = (i + j) /2 + 1;	// Make mid biased to the right//////////////////
//            if (A[mid] > target) j = mid - 1;
//            else i = mid;				// So that this won't make the search range stuck.
//        }
//        ret[1] = j;
//        return ret;
//    }
}

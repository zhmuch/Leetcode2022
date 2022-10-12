package com.example.kotlinplayground.google

/**
 * 88. Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/
 */
class MergeSortedArray {

    /**
     * Solution 1,
     *
     * put all nums together
     * and sort in place
     */

    /**
     * Solution 2,
     *
     * Three pointer
     * 1. if start from beginning, need to copy array
     * 2. if start from end, we can sort in place
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index1 = m - 1
        var index2 = n - 1

        for (index in (m + n - 1) downTo  0) {
            if (index1 < 0) {
                nums1[index] = nums2[index2]
                index2--
                continue
            }
            if (index2 < 0) {
                nums1[index] = nums1[index1]
                index1--
                continue
            }
            if (nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1]
                index1--
            } else {
                nums1[index] = nums2[index2]
                index2--
            }
        }
    }
}

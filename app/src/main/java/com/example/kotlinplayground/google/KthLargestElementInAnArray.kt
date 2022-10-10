package com.example.kotlinplayground.google

/**
 * 215. Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
class Solution {

    /**
     * Solution 0,
     *
     * Sort
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sort()
        val size = nums.size
        return nums[size - k]
    }

    /**
     * Solution 1,
     *
     * Divide and conquer,
     * Binary search,
     * Quick select
     */

    /**
     * Solution 2,
     *
     * Heap
     *
     * The idea is to init a heap "the smallest element first", and add all elements from the
     * array into this heap one by one keeping the size of the heap always less or equal to k.
     * That would results in a heap containing k largest elements of the array.
     */
}

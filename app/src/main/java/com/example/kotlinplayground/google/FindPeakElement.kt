package com.example.kotlinplayground.google

/**
 * 162. Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/
 */
class FindPeakElement {

    /**
     * Solution 1:
     *
     * Straight forward,
     * traverse all elements in O(n)
     */

    /**
     * Solution 2:
     *
     * Binary search,
     *
     *
     */
    fun findPeakElement(nums: IntArray): Int {
        return search(nums, 0, nums.size - 1)
    }

    private fun search(nums: IntArray, l: Int, r: Int): Int {
        if (l == r) {
            return l
        }
        val mid = (l + r) / 2
        return if (nums[mid] < nums[mid + 1]) {
            search(nums, mid + 1, r)
        } else {
            search(nums, l, mid)
        }
    }
}

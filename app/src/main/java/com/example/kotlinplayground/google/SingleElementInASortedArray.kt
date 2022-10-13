package com.example.kotlinplayground.google

/**
 * 540. Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
class SingleElementInASortedArray {

    /**
     * Solution 1:
     *
     * Traverse, add them one by one, with changing + and -
     */

    /**
     * Solution 2:
     *
     * Binary search
     * validate each half depends on pivot point
     */
    fun singleNonDuplicate(nums: IntArray): Int {
        return findSingle(nums, 0, nums.size - 1)
    }

    private fun findSingle(nums: IntArray, l: Int, r: Int): Int {
        if (l == r) {
            return nums[l]
        }
        val mid = (l + r) / 2
        return if (nums[mid] == nums[mid - 1]) {
            if ((mid - l - 1).rem(2) == 0) {
                findSingle(nums, mid + 1, r)
            } else {
                findSingle(nums, l, mid - 2)
            }
        } else if (nums[mid] == nums[mid + 1]) {
            if ((mid - l).rem(2) == 0) {
                findSingle(nums, mid + 2, r)
            } else {
                findSingle(nums, l, mid - 1)
            }
        } else {
            nums[mid]
        }
    }

    /**
     * Solution 3: Binary Search on Evens Indexes Only
     * It turns out that we only need to binary search on the even indexes.
     * This approach is more elegant than the last, although both are good solutions.
     */
}

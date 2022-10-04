package com.example.kotlinplayground.google

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
class SearchInsertPosition {

    /**
     * Solution 1
     * Traverse
     */

    /**
     * Solution 2, binary search
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while(left != right) {
            val pivot = (left + right) / 2
            if (nums[pivot] >= target) {
                right = pivot
            } else {
                left = pivot + 1
            }
        }

        return if (nums[left] >= target) {
            left
        } else {
            left + 1
        }
    }
}

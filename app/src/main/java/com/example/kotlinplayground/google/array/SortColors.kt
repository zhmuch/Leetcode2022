package com.example.kotlinplayground.google.array

/**
 * 75. Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/
 */
class Solution {

    /**
     * Solution 1:
     *
     * 3 lists for each type
     */

    /**
     * Solution 2:
     *
     * The problem is known as Dutch National Flag Problem and first was proposed by
     * Edsger W. Dijkstra. The idea is to attribute a color to each number and then to arrange
     * them following the order of colors on the Dutch flag.
     *
     * Let's use here three pointers to track the rightmost boundary of zeros, the
     * leftmost boundary of twos and the current element under the consideration.
     */

    /**
     * Solution 3:
     *
     * Count number
     */
    fun sortColors(nums: IntArray): Unit {
        var red = 0
        var white = 0
        var blue = 0

        for (num in nums) {
            when (num) {
                0 -> red++
                1 -> white++
                2 -> blue++
                else -> return
            }
        }

        for (i in 0 until red) {
            nums[i] = 0
        }
        for (i in 0 until white) {
            nums[i + red] = 1
        }
        for (i in 0 until blue) {
            nums[i + red + white] = 2
        }
    }
}

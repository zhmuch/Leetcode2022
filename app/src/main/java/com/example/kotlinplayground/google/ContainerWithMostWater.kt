package com.example.kotlinplayground.google

/**
 * 11. Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
class ContainerWithMostWater {

    /**
     * Solution 1:
     *
     * Brute force
     * pick any pair of lines
     */

    /**
     * Solution 2:
     *
     * Two pointer
     *
     * proof:
     * We starts with the widest container, l = 0 and r = n - 1.
     * Let's say the left one is shorter: h[l] < h[r]. Then, this is already the largest container
     * the left one can possibly form. There's no need to consider it again.
     * Therefore, we just throw it away and start again with l = 1 and r = n -1.
     */
    fun maxArea(height: IntArray): Int {
        var max = 0
        var l = 0
        var r = height.size - 1

        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]))
            if (height[l] < height[r]) {
                l++
            } else {
                r--
            }
        }
        return max
    }
}

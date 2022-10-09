package com.example.kotlinplayground.google

/**
 * 1937. Maximum Number of Points with Cost
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/
 */
class MaximumNumberOfPointsWithCost {

    /**
     * Solution 1:
     *
     * Obviously, dp
     *
     * the optimal solution in current row only depends on the row above
     *
     * to optimized, keep only two row.
     */
    fun maxPoints(points: Array<IntArray>): Long {
        val row = points.size
        val col = points[0].size

        // init
        val maxPoints = Array(row) { IntArray(col) }
        for (i in points[0].indices) {
            maxPoints[0][i] = points[0][i]
        }

        for (j in 1 until row) {
            for (k in 0 until col) {
                var max = 0
                for (l in 0 until col) {
                    max = Math.max(max, points[j][k] + maxPoints[j - 1][l] - abs(k, l))
                }
                maxPoints[j][k] = max
            }
        }

        return points[row - 1].max()!!.toLong()
    }

    private fun abs(a: Int, b: Int) = kotlin.math.abs(a - b)

    /**
     * Solution 2:
     *
     * To further optimize:
     * Notice that, for a certain index i, the maximum value for i is a index that could either
     * come from its left, or its right(inclusive). Thus we can build two arrays, lft and rgt, and
     * focus on the maximum value only coming from its left or right. Finding the best fit for a
     * single index i could just cost O(1) time from then on.
     */
}

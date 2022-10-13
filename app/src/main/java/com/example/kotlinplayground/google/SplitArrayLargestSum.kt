package com.example.kotlinplayground.google

/**
 * 410. Split Array Largest Sum
 *
 * https://leetcode.com/problems/split-array-largest-sum/
 */
class SplitArrayLargestSum {

    /**
     * Solution 1
     *
     * Greedy?
     */

    /**
     * Solution 2
     *
     * DP
     */
    fun splitArray(nums: IntArray, k: Int): Int {
        if (nums.size == 1) {
            return nums[0]
        }

        val row = k
        val col = nums.size

        val dp = Array(row) { IntArray(col) }

        // init dp table
        var sum = 0
        for (i in 0 until col) {
            sum += nums[i]
            dp[0][i] = sum
        }
        for (i in 0 until row) {
            dp[i][0] = nums[0]
        }

        for (r in 1 until row) {
            for (c in 1 until col) {
                var min = Int.MAX_VALUE
                var currIndex = c
                var currSum = 0

                while (true) {
                    if (currIndex < 1) {
                        break
                    }
                    currSum += nums[currIndex]
                    var currMax = Math.max(currSum, dp[r - 1][currIndex - 1])
                    min = Math.min(min, currMax)
                    if (currMax == currSum) {
                        break
                    }
                    currIndex--
                }
                dp[r][c] = min
            }
        }
        return dp[row - 1][col - 1]
    }

    /**
     * Interesting
     *
     * Solution 3: Binary Search
     *
     * The characteristics of this problem are a good fit for the dynamic programming solution hence,
     * it's easy to overlook the idea of using binary search. This problem satisfies the property
     * that we can guess the answer (the minimum largest sum subarray value) and check if that value
     * was too high or too low, thus narrowing our search space. It requires a different perspective
     * to think of this approach, but after realizing that this problem is a candidate for a binary
     * search solution, it becomes easier to implement than the previous approaches.
     *
     * ===================
     * it is similar to Solution 1.
     * except, the greedy works when checking if a certain X value (sum) can satisfy k-sub-arrays
     * ===================
     *
     * https://leetcode.com/problems/split-array-largest-sum/solution/
     */
}

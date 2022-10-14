package com.example.kotlinplayground.google

import java.util.*

/**
 * 16. 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/
 */
class ThreeSumClosest {

    /**
     * Solution 1
     *
     * brute force
     */

    /**
     * Solution 2
     *
     * Similar to 15. 3Sum
     */
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closest = Int.MAX_VALUE
        var closestSum = Int.MIN_VALUE

        for (i in nums.indices) {
            val currTarget = target - nums[i]

            var l = i + 1
            var r = nums.size - 1

            while (l < r) {
                val currSum = nums[l] + nums[r]
                val distance = Math.abs(currTarget - currSum)
                if (distance < closest) {
                    closest = distance
                    closestSum = currSum + nums[i]
                }
                if (currTarget > currSum) {
                    l++
                } else {
                    r--
                }
            }
        }

        return closestSum
    }

    /**
     * Solution 3: Binary Search
     *
     * Interesting
     * We can adapt the 3Sum Smaller: Binary Search approach to this problem.
     * In the two pointers approach, we fix one number and use two pointers to enumerate pairs.
     * Here, we fix two numbers, and use a binary search to find the third complement number.
     * This is less efficient than the two pointers approach,
     * however, it could be more intuitive to come up with.
     */
}

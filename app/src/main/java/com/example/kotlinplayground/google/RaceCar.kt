package com.example.kotlinplayground.google

import kotlin.math.log2
import kotlin.math.min

/**
 * 818. Race Car
 * https://leetcode.com/problems/race-car/
 */
class RaceCar {
    /**
     * Solution 1:
     * Brutal force
     *
     * Recursive find target <= 2^n : n is minimum
     * n should be the upperbound
     */

    /**
     * Solution 2:
     * Dynamic programming
     *
     * 1. N[i] is the length of shortest sequence of instructions to get to position i
     * 2. Notice speed grow exponentially
     * 3. Only need to memorize the positions in: N[0], N[1], N[3], N[7], N[15], ...
     *
     * to be continued...
     */

    /**
     * Solutions 3: DP
     *
     * Greedy first, to make assumption
     *
     * 1. Go pass our target , stop and turn back
        We take n instructions of A.
        1 + 2 + 4 + ... + 2 ^ (n-1) = 2 ^ n - 1
        Then we turn back by one R instruction.
        In the end, we get closer by n + 1 instructions.

        2. Go as far as possible before pass target, stop and turn back
        We take n - 1 instruction of A and one R.
        Then we take m instructions of A, where m < n
     */
    fun racecar(target: Int): Int {
        val dp = IntArray(target + 1) { -1}
        dp[0] = 0
        return racecarFinder(target, dp)
    }

    private fun racecarFinder(target: Int, dp: IntArray): Int {
        // Result has been memorized
        if (dp[target] >= 0) {
            return dp[target]
        }

        val steps: Int = log2(target.toDouble()).toInt() + 1

        if ((1 shl steps) - 1 == target) {          // right at the point
            dp[target] = steps
        } else {
            // pass target situation
            dp[target] = racecarFinder(((1 shl steps) - 1) - target, dp) + steps + 1
            // before target situation
            for (m: Int in 0 until steps - 1) {
                dp[target] = min(
                    dp[target],
                    racecarFinder(target - ((1 shl (steps - 1)) - 1) + (1 shl m) - 1, dp) + steps + 1 + m
                )
            }
        }

        return dp[target]
    }
}

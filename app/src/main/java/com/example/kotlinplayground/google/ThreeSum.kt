package com.example.kotlinplayground.google

import java.util.LinkedList

/**
 * 15. 3Sum
 *
 * https://leetcode.com/problems/3sum/
 */
class ThreeSum {

    /**
     * Solution 1:
     *
     * Brute force
     * search for all posible combination
     */

    /**
     * Solution 2:
     *
     * Sort
     * and use two pointer to find valid combination
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = LinkedList<List<Int>>()

        for (i in nums.indices) {
            val base = nums[i]

            // fast fail
            if (base > 0) {
                break
            }

            // de-duplicate
            if (i != 0 && base == nums[i - 1]) {
                continue
            }

            var l = i + 1
            var r = nums.size - 1

            while (l < r) {
                if (0 == base + nums[l] + nums[r]) {
                    result.add(listOf(base, nums[l], nums[r]))
                    r--
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--
                    }
                    l++
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++
                    }
                } else if (0 < base + nums[l] + nums[r]) {
                    r--
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--
                    }
                } else {
                    l++
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++
                    }
                }
            }
        }

        return result
    }

    /**
     * Solution 3:
     *
     * Hashset
     * Since triplets must sum up to the target value, we can try the hash table approach from the
     * Two Sum solution. This approach won't work, however, if the sum is not necessarily equal to
     * the target, like in 3Sum Smaller and 3Sum Closest.
     *
     * create a hash set for each iteration
     */
}

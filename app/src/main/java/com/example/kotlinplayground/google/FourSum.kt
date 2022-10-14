package com.example.kotlinplayground.google

import java.util.*

/**
 * 18. 4Sum
 *
 * https://leetcode.com/problems/4sum/
 */
class FourSum {

    /**
     * Solution 1:
     *
     * iterate, and use 3Sum
     */
    fun fourSum(nums: IntArray, target: Int): List<MutableList<Int>> {
        Arrays.sort(nums)
        return kSum(nums, target.toLong(), 0, 4)
    }

    fun kSum(nums: IntArray, target: Long, start: Int, k: Int): List<MutableList<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()

        // If we have run out of numbers to add, return res.
        if (start == nums.size) {
            return res
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        val average_value = target / k

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.size - 1]) {
            return res
        }
        if (k == 2) {
            return twoSum(nums, target, start)
        }
        for (i in start until nums.size) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (subset in kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(ArrayList(mutableListOf(nums[i])))
                    res[res.size - 1].addAll(subset)
                }
            }
        }
        return res
    }

    fun twoSum(nums: IntArray, target: Long, start: Int): List<MutableList<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()
        var lo = start
        var hi = nums.size - 1
        while (lo < hi) {
            val currSum = nums[lo] + nums[hi]
            if (currSum < target || lo > start && nums[lo] == nums[lo - 1]) {
                ++lo
            } else if (currSum > target || hi < nums.size - 1 && nums[hi] == nums[hi + 1]) {
                --hi
            } else {
                res.add(mutableListOf(nums[lo++], nums[hi--]))
            }
        }
        return res
    }

    /**
     * General solution
     *
     * Ksum problem
     * (k)sum -> (k-1)sum -> 2sum
     *
     * and we could use
     * 1. hashset
     * 2. two pointer
     * to solve 2 sum problems
     */
}

package com.example.kotlinplayground.google

/**
 * 001
 * https://leetcode.com/problems/two-sum/
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    return loopFind(nums, target)
}

/**
 * Naive loop find
 */
fun loopFind(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in (i + 1) until nums.size) {
            val sum = nums[i] + nums[j]
            if (sum == target) {
                return intArrayOf(i, j)
            }
        }
    }
    // Invalid return value
    return intArrayOf(-1, -1)
}

/**
 * Use more space to memorize result
 */
fun hashtableFind(nums: IntArray, target: Int): IntArray {
    val records = HashMap<Int, Int>()
    for (i in nums.indices) {
        val remain = target - nums[i]
        records[remain].also { remainIndex ->
            if (remainIndex != null) {
                return intArrayOf(remainIndex, i)
            } else {
                records[nums[i]] = i
            }
        }
    }
    // Invalid return value
    return intArrayOf(-1, -1)
}

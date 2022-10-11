package com.example.kotlinplayground.google

import java.util.Hashtable

/**
 * 128. Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
class LongestConsecutiveSequence {

    /**
     * Solution 1,
     *
     * Sort and traverse
     */

    /**
     * Solution 2,
     *
     * Union Find
     *
     */
    fun longestConsecutive(nums: IntArray): Int {
        var maxCount = 0

        val left = Hashtable<Int, Int>()
        val right = Hashtable<Int, Int>()
        val dup = java.util.HashSet<Int>()

        for (num in nums) {
            if (!dup.contains(num)) {
                dup.add(num)
                var tmpCount = 0
                // Union two set
                if (left.containsKey(num + 1) && right.containsKey(num - 1)) {
                    val lLength = left[num + 1]!!
                    val r = num + lLength

                    val rLength = right[num - 1]!!
                    val l = num - rLength

                    val newLength = lLength + rLength + 1

                    left.remove(num + 1)
                    right.remove(num - 1)
                    left[l] = newLength
                    right[r] = newLength
                    tmpCount = newLength
                } else if (left.containsKey(num + 1)) {
                    var length = left[num + 1]!!
                    val r = num + length
                    length++

                    left.remove(num + 1)
                    left[num] = length
                    right[r] = length
                    tmpCount = length
                } else if (right.containsKey(num - 1)) {
                    var length = right[num - 1]!!
                    val l = num - length
                    length++

                    right.remove(num - 1)
                    right[num] = length
                    left[l] = length
                    tmpCount = length
                } else {
                    left[num] = 1
                    right[num] = 1
                    tmpCount = 1
                }
                maxCount = Math.max(maxCount, tmpCount)
            }
        }

        return maxCount
    }
}

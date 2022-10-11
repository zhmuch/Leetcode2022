package com.example.kotlinplayground.google

import java.util.*

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

    /**
     * Solution 3
     *
     * Cleaner solution
     * This optimized algorithm contains only two changes from the brute force approach:
     * the numbers are stored in a HashSet (or Set, in Python) to allow O(1)O(1) lookups,
     * and we only attempt to build sequences from numbers that are not already part of a
     * longer sequence. This is accomplished by first ensuring that the number that would
     * immediately precede the current number in a sequence is not present, as that number
     * would necessarily be part of a longer sequence.
     */
    open fun longestConsecutive2(nums: IntArray): Int {
        val num_set: MutableSet<Int> = HashSet()
        for (num in nums) {
            num_set.add(num)
        }
        var longestStreak = 0
        for (num in num_set) {
            if (!num_set.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                }
                longestStreak = Math.max(longestStreak, currentStreak)
            }
        }
        return longestStreak
    }
}

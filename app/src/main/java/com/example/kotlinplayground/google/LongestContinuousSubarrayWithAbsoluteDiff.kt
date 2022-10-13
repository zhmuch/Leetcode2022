package com.example.kotlinplayground.google

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue
import java.util.TreeMap

/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 *
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
class LongestContinuousSubarrayWithAbsoluteDiff {

    /**
     * Solution 1:
     *
     * 1. keep a sliding window
     * 2. take advantage of TreeMap, to get max and min in O(lgN) time
     * 3. traverse and count
     */
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        var i = 0
        val map = TreeMap<Int, Int>()

        for (j in nums.indices) {
            map[nums[j]] = map.getOrDefault(nums[j], 0) + 1
            if (map.lastEntry()!!.key - map.firstEntry()!!.key > limit) {
                map[nums[i]] = map[nums[i]]!! - 1
                if (map[nums[i]] == 0) {
                    map.remove(nums[i])
                }
                i++
            }
        }

        return nums.size - i
    }

    /**
     * Solution 2:
     *
     * Similar to solution 1
     * using binary insert to keep the sliding window elements in order.
     */

    /**
     * Solution 3: Use two heaps
     *
     * 1. min heap and max heap
     * 2. find the index of the min or max element position
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun longestSubarray2(nums: IntArray, limit: Int): Int {
        val minHeap = PriorityQueue<Array<Int>> { i1, i2 -> i1[0] - i2[0] }
        val maxHeap = PriorityQueue<Array<Int>> { i1, i2 -> i2[0] - i1[0] }

        var leftIndex = 0
        var max = 0
        for (currIndex in nums.indices) {
            minHeap.offer(arrayOf(nums[currIndex], currIndex))
            maxHeap.offer(arrayOf(nums[currIndex], currIndex))

            while (maxHeap.peek()!![0] - minHeap.peek()!![0] > limit) {
                // Remove the current peek element position (max or min)
                leftIndex = Math.min(maxHeap.peek()!![1], minHeap.peek()!![1]) + 1
                while (maxHeap.peek()!![1] < leftIndex) { maxHeap.poll() }
                while (minHeap.peek()!![1] < leftIndex) { minHeap.poll() }
            }

            max = Math.max(max, currIndex - leftIndex + 1)
        }

        return max
    }

    /**
     * Solution 4:
     *
     * similar to solution 1,
     * with a clever way
     *
     * 单调 two deque
     *
     * maxDeque = [8, 6, 4, 3, 2]
     * minDeque = [2, 3, 4]
     */
}

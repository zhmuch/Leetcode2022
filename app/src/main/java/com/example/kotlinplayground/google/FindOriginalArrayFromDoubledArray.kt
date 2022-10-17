package com.example.kotlinplayground.google

/**
 * 2007. Find Original Array From Doubled Array
 *
 * https://leetcode.com/problems/find-original-array-from-doubled-array/
 */
class FindOriginalArrayFromDoubledArray {

    fun findOriginalArray(changed: IntArray): IntArray {

    }

    /**
     * Solution 1:
     *
     * Sort array,
     * greedy, find the smallest pair
     */

    /**
     * Solution 2:
     *
     * (Interesting)
     * Counting Sort
     *
     * Similar to the previous approach, we will find the smallest element always. The only
     * difference here is that instead of sorting the original array using built-in sorting
     * functions we will use counting sort. We will use an array freq to store the frequency
     * of each element in the given array. Now, we will iterate from 0 to the maximum value
     * that is present in the array. For each element num we will follow the exact same process
     * as we did previously, we check for the element 2 * num and proceed accordingly.
     */
}

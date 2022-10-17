package com.example.kotlinplayground.google

/**
 * 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 *
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 */
class FindTwoNonoverlappingSubarraysEachWithTargetSum {

    fun minSumOfLengths(arr: IntArray, target: Int): Int {

    }

    /**
     * Solution 1:
     *
     * DP from both sides
     */

    /**
     * Solution 2:
     *
     * Hashtable
     * two-passes
     *
     * Concept: First traverse through the array once and store the (key,value) pair as
     * (sum(arr[0:i+1]),i) for 0<=i<size of arr. Put, (0,-1) in hashmap as default. Now traverse
     * through the array again, and for every i, find the minimum value of length of sub-array on
     * the left or starting with i whose value is equal to target. Find another sub-array starting
     * with i+1, whose sum is target. Update the result with the minimum value of the sum of both
     * the sub-array. This is possible because all values are positive and the value of sum is
     * strictly increasing.
     */
}

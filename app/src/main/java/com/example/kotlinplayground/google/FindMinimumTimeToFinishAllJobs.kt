package com.example.kotlinplayground.google

/**
 * 1723. Find Minimum Time to Finish All Jobs
 *
 * https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/
 */
class FindMinimumTimeToFinishAllJobs {

    fun minimumTimeRequired(jobs: IntArray, k: Int): Int {

    }

    /**
     * Check if a time upper bound is achievable
     */

    /**
     * Solution 1:
     *
     * Greedy?
     */


    /**
     * Solution 2: DFS
     *
     * Optimization 1:
     * we assign the most time consuming job first.
     *
     * Optimization 2:
     * Assign a job to totally free worker only once.
     *
     * Optimization 3:
     * Update the res and don't go forward if work load already >= result
     */

    /**
     * Solution 3: Bianry search
     *
     * The problem of the first solution,
     * is that the upper bound reduce not quick enough.
     * Apply binary search, to reduce the upper bound more quickly.
     */
}

package com.example.kotlinplayground.google

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

/**
 * 56. Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/
 */
class MergeIntervals {

    /**
     * Solutions 1:
     *
     * Brute force, similar to merge sort,
     * compare each one to the result intervals
     * merge if needed
     */

    /**
     * Solutions 2:
     *
     * Put all internals in a min-heap based on start
     */

    /**
     * Solution 3:
     *
     * Only keep record of start and end time.
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf()
        }

        val starts = arrayListOf<Int>()
        val ends = arrayListOf<Int>()

        for (interval in intervals) {
            starts.add(interval[0])
            ends.add(interval[1])
        }

        starts.sort()
        ends.sort()

        val result = arrayListOf<IntArray>()
        val curr: IntArray = IntArray(2).also {
            it[0] = -1
            it[1] = -1
        }
        for (i in starts.indices) {
            if (curr[0] == -1) {
                curr[0] = starts[i]
                curr[1] = ends[i]
            } else {
                if (starts[i] > curr[1]) {
                    result.add(IntArray(2).also {
                        it[0] = curr[0]
                        it[1] = curr[1]
                    })
                    curr[0] = starts[i]
                    curr[1] = ends[i]
                } else {
                    curr[1] = ends[i]
                }
            }
        }
        result.add(IntArray(2).also {
            it[0] = curr[0]
            it[1] = curr[1]
        })

        return Array(result.size) { i -> result[i]}
    }
}
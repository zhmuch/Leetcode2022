package com.example.kotlinplayground.google

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue

/**
 * 973. K Closest Points to Origin
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
class KClosestPointsToOrigin {

    /**
     * Solution 1,
     *
     * calculate distance and sort
     */

    /**
     * Solution 2,
     *
     * maintain a heap
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val distance = Array(points.size) { i ->
            points[i].calculateDistance()
        }

        val minHeap = PriorityQueue<Int> { i1, i2 ->
            if (distance[i1] < distance[i2]) {
                -1
            } else {
                1
            }
        }

        for (i in points.indices) {
            minHeap.offer(i)
        }

        return Array(k) {
            points[minHeap.poll()!!]
        }
    }

    private fun IntArray.calculateDistance(): Double =
        Math.sqrt((this[0] * this[0] + this[1] * this[1]).toDouble())

    /**
     * Approach 2: Divide and Conquer
     *
     * Say we choose some random element x = A[i] and split the array into two buckets:
     * one bucket of all the elements less than x,
     * and another bucket of all the elements greater than or equal to x.
     * This is known as "quickselecting by a pivot x".
     */
}
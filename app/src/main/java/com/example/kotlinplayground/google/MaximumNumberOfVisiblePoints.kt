package com.example.kotlinplayground.google

import java.util.LinkedList

/**
 * 1610. Maximum Number of Visible Points
 *
 * https://leetcode.com/problems/maximum-number-of-visible-points/
 */
class MaximumNumberOfVisiblePoints {

    /**
     * Solution 1:
     *
     * Brute force, start from each node, counterwise, check if any node fall into the view
     */

    /**
     * Solution 2:
     *
     * Take the advice,
     * Sort the points by polar angle with the original position.
     * Now only a consecutive collection of points would be visible from any coordinate.
     */
    fun visiblePoints(points: List<List<Int>>, angle: Int, location: List<Int>): Int {
        var maxCount = 0

        val pointsPool = LinkedList<Double>()

        for (point in points) {
            if (point[0] == location[0] && point[1] == location[1]) {
                maxCount++
            } else {
                pointsPool.add(getPolarAngle(location[0], location[1], point[0], point[1]))
                pointsPool.add(getPolarAngle(location[0], location[1], point[0], point[1]) + 360)
            }
        }

        pointsPool.sort()

        for (left in 0 until(pointsPool.size / 2)) {
            val leftAngle = pointsPool[left]
            val maxAngle = leftAngle + angle

            var count = 0
            var right = left
            while (pointsPool[right] <= maxAngle) {
                count++
                right++
            }
            maxCount = Math.max(maxCount, count)
        }

        return maxCount
    }

    fun getPolarAngle(x1: Int, y1: Int, x2: Int, y2: Int): Double {
        val a = Math.atan2((y2 - y1).toDouble(), (x2 - x1).toDouble())
        var degree = Math.toDegrees(a)
        if (degree < 0) {
            degree += 360.0
        }
        return degree
    }

    /**
     * Clean Code:
     */

    open fun visiblePoints2(points: List<List<Int>>, angle: Int, location: List<Int>): Int {
        val angles: MutableList<Double> = ArrayList()
        var count = 0
        for (p in points) {
            val dx = p[0] - location[0]
            val dy = p[1] - location[1]
            if (dx == 0 && dy == 0) { // edge case of same point
                count++
                continue
            }
            angles.add(Math.atan2(dy.toDouble(), dx.toDouble()) * (180 / Math.PI))
        }
        angles.sort()
        val tmp: MutableList<Double> = ArrayList(angles)
        for (d in angles) tmp.add(d + 360) // concatenate to handle edge case
        var res = count
        var i = 0
        var j = 0
        while (i < tmp.size) {
            while (tmp[i] - tmp[j] > angle) {                   //KEEP A WINDOW
                j++
            }
            res = Math.max(res, count + i - j + 1)
            i++
        }
        return res
    }
}
package com.example.kotlinplayground.google

import java.util.LinkedList

/**
 * 54. Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/
 */
class SpiralMatrix {

    /**
     * Solution 1:
     * another matrix to check if it has been visited
     * switch direction based on state
     */

    /**
     * Solution 2:
     *
     * for loop
     * each loop, iterate four direction
     */
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val row = matrix.size
        val col = matrix[0].size

        val result = LinkedList<Int>()

        var leftBound = 0
        var rightBound = col - 1
        var upperBound = 0
        var lowerBound = row - 1

        while (leftBound <= rightBound && upperBound <= lowerBound) {
            result.addAll(boundOrder(matrix, leftBound, rightBound, upperBound, lowerBound))
            leftBound++
            rightBound--
            upperBound++
            lowerBound--
        }

        return result
    }

    fun boundOrder(
        matrix: Array<IntArray>,
        leftBound: Int,
        rightBound: Int,
        upperBound: Int,
        lowerBound: Int
    ): List<Int> {
        val result = LinkedList<Int>()

        for (i in leftBound..rightBound) {
            result.add(matrix[upperBound][i])
        }

        for (i in (upperBound + 1)..(lowerBound - 1)) {
            result.add(matrix[i][rightBound])
        }

        if (upperBound < lowerBound) {
            for (i in rightBound downTo leftBound) {
                result.add(matrix[lowerBound][i])
            }
        }

        if (leftBound < rightBound) {
            for (i in (lowerBound - 1) downTo (upperBound + 1)) {
                result.add(matrix[i][leftBound])
            }
        }

        return result
    }
}
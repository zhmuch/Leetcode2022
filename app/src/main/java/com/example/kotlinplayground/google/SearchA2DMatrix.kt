package com.example.kotlinplayground.google

/**
 * 74. Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
class SearchA2DMatrix {

    /**
     * Solution 1
     *
     * Binary search
     * on matrix in place
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val row = findRow(matrix, target, 0, matrix.size - 1)
        return findInRow(matrix, target, row, 0, matrix[row].size - 1)
    }

    private fun findRow(matrix: Array<IntArray>, target: Int, row1: Int, row2: Int): Int {
        if (row1 == row2) {
            return row1
        }
        val midRow = (row1 + row2) / 2
        return if (matrix[midRow].last() < target) {
            findRow(matrix, target, midRow + 1, row2)
        } else {
            findRow(matrix, target, row1, midRow)
        }
    }

    private fun findInRow(matrix: Array<IntArray>, target: Int,
                          row: Int, start: Int, end: Int
    ): Boolean {
        if (start == end) {
            return matrix[row][start] == target
        }
        val mid = (start + end) / 2
        return  if (matrix[row][mid] < target) {
            findInRow(matrix, target, row, mid + 1, end)
        } else {
            findInRow(matrix, target, row, start, mid)
        }
    }

    /**
     * Solution 2
     *
     * Binary search
     * serialize
     */
}

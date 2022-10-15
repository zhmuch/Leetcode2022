package com.example.kotlinplayground.google

import java.util.LinkedList

/**
 * 200. Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/
 */
class NumberOfIslands {

    /**
     * Solution 1
     *
     * BFS + Union Find
     */
    fun numIslands(grid: Array<CharArray>): Int {
        val row = grid.size
        val col = grid[0].size

        var count = 0

        for (i in 0 until row) {
            for (j in 0 until col) {
                val c = grid[i][j]
                if ('1' != c) {
                    continue
                } else {
                    count++
                    val queue = LinkedList<Pair<Int, Int>>().also { it.add(Pair(i, j)) }
                    while (queue.isNotEmpty()) {
                        val curr = queue.poll()!!

                        if (curr.first < 0 || curr.first >= row ||
                            curr.second < 0 || curr.second >= col) {
                            continue
                        }

                        if ('1' != grid[curr.first][curr.second]) {
                            continue
                        }

                        // means visited
                        grid[curr.first][curr.second] = '2'

                        queue.offer(Pair(curr.first + 1, curr.second))
                        queue.offer(Pair(curr.first - 1, curr.second))
                        queue.offer(Pair(curr.first, curr.second + 1))
                        queue.offer(Pair(curr.first, curr.second - 1))
                    }
                }
            }
        }

        return count
    }

    /**
     * Solution 2
     *
     * DFS
     */

    /**
     * Solution 3
     *
     * Union Find
     */
}

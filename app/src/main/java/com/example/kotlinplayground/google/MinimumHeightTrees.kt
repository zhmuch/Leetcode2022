package com.example.kotlinplayground.google

/**
 * 310. Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees/
 */
class MinimumHeightTrees {

    /**
     * Solution 1:
     *
     * Find the longest path, using BFS
     * the middle point will be the root
     */
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {

    }

    /**
     * Solution 2: interesting
     *
     * Given the above intuition, the problem is now reduced down to looking for all the centroid
     * nodes in a tree-alike graph, which in addition are no more than two.
     *
     * Key idea, remove leaf node during each iteration
     */
}

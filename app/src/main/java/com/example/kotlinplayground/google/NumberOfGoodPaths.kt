package com.example.kotlinplayground.google

import java.util.LinkedList
import java.util.Queue

/**
 * 2421. Number of Good Paths
 * https://leetcode.com/problems/number-of-good-paths/
 */
class NumberOfGoodPaths {

    /**
     * Solution:
     * Using BFS or DFS to consist all possible paths
     *
     * Count the number of ood paths
     *
     * Maintain the property of:
     * StartPoint.index > EndPoint.index
     * to avoid duplication
     */
    fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
        // Initialization
        val size = vals.size
        val nodes: Array<Node> = Array(size) { index ->
            Node(index, LinkedList())
        }

        for (edge in edges) {
            nodes[edge[0]].adjacent.add(edge[1])
            nodes[edge[1]].adjacent.add(edge[0])
        }

        var count = 0
        // BFS, search for all path started from a node, length > 1
        for (i in 0 until size) {
            // Target value to form a good path
            val goodValue = vals[i]

            val checked = HashSet<Int>()
            val visitedNodes: Queue<Node> = LinkedList()
            visitedNodes.offer(nodes[i])

            while (visitedNodes.isNotEmpty()) {
                val currentNode = visitedNodes.poll()!!
                if (vals[currentNode.index] > goodValue) {
                    // Cannot be a good path, do nothing
                } else {
                    if (vals[currentNode.index] == goodValue && currentNode.index >= i) {
                        count++
                    }
                    for (n in currentNode.adjacent) {
                        if (!checked.contains(n)) {
                            visitedNodes.offer(nodes[n])
                        }
                    }
                }
                checked.add(currentNode.index)
            }
        }

        return count
    }

    private data class Node(
        val index: Int,
        val adjacent: LinkedList<Int>
    )
}
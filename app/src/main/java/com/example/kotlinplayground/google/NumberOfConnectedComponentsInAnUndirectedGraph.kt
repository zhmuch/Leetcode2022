package com.example.kotlinplayground.google

/**
 * 323. Number of Connected Components in an Undirected Graph
 *
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
class NumberOfConnectedComponentsInAnUndirectedGraph {

    /**
     * Solution 1:
     *
     * DFS
     */

    /**
     * Solution 2:
     *
     * Union Find
     *
     * others code:
     */
    private fun find(representative: IntArray, vertex: Int): Int {
        return if (vertex == representative[vertex]) {
            vertex
        } else find(representative, representative[vertex]).also { representative[vertex] = it }
    }

    private fun combine(representative: IntArray, size: IntArray, vertexI1: Int, vertexI2: Int): Int {
        var vertex1 = vertexI1
        var vertex2 = vertexI2
        vertex1 = find(representative, vertex1)
        vertex2 = find(representative, vertex2)
        return if (vertex1 == vertex2) {
            0
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2]
                representative[vertex2] = vertex1
            } else {
                size[vertex2] += size[vertex1]
                representative[vertex1] = vertex2
            }
            1
        }
    }

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val representative = IntArray(n)
        val size = IntArray(n)
        for (i in 0 until n) {
            representative[i] = i
            size[i] = 1
        }
        var components = n
        for (i in edges.indices) {
            components -= combine(representative, size, edges[i][0], edges[i][1])
        }
        return components
    }
}

package com.example.kotlinplayground.google

import java.util.LinkedList

/**
 * 2277. Closest Node to Path in Tree
 * https://leetcode.com/problems/closest-node-to-path-in-tree/
 */
class ClosestNodeToPathInTree {

    /**
     * Solution 1
     *
     * Naive
     *
     * 1. Use [edges] to construct the tree
     * 2. Given a query = [start, end, node]
     *    Find the path from [start] to [end], store all the nodes
     * 3. Find the path from [start] to [node]
     * 4. Compare two path, find the node it diverge
     */
    fun closestNode(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val nodes = HashMap<Int, TreeNode> ()
        for (index in 0 until n) {
            nodes[index] = TreeNode(index)
        }

        for (edge in edges) {
            val node1 = nodes[edge[0]]!!
            val node2 = nodes[edge[1]]!!
            node1.connected.add(node2)
            node2.connected.add(node1)
        }

        val querySize = query.size
        val result: IntArray = IntArray(querySize)
        for (index in 0 until querySize) {
            result[index] = findCloestNode(nodes, query[index][0], query[index][1], query[index][2])
        }

        return result
    }

    fun findCloestNode(nodes: HashMap<Int, TreeNode>, start: Int, end: Int, node: Int): Int {
        val endPath = findPath(nodes[start]!!, -1, end)!!
        val nodePath = findPath(nodes[start]!!, -1, node)!!

        var index = 0
        var prev = 0
        while(index < endPath.size && index < nodePath.size) {
            if (endPath[index] != nodePath[index]) {
                return endPath[prev]
            }
            prev = index
            index++
        }
        return endPath[prev]
    }

    fun findPath(currentNode: TreeNode, prev: Int, target: Int): LinkedList<Int>? {
        if (currentNode.id == target) {
            return LinkedList<Int>().apply { add(target) }
        }

        var result: LinkedList<Int>? = null
        for (child in currentNode.connected) {
            if (child.id != prev) {
                val res = findPath(child, currentNode.id, target)
                res?.addFirst(currentNode.id)
                result = res
            }
        }
        return result
    }

    data class TreeNode(val id: Int, val connected: LinkedList<TreeNode> = LinkedList())
}
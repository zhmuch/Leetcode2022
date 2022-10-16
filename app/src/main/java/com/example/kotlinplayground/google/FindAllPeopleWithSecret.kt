package com.example.kotlinplayground.google

/**
 * 2092. Find All People With Secret
 *
 * https://leetcode.com/problems/find-all-people-with-secret/
 */
class FindAllPeopleWithSecret {

    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {

    }

    /**
     * Solution 1:
     *
     * Brute force
     *
     * update after each meeting
     */

    /**
     * Solution 2:
     *
     * union find,
     * sort by time
     * https://leetcode.com/problems/find-all-people-with-secret/discuss/1599942/Java-Union-Find-with-Reset-(2-solutions)
     */

    private class UF(n: Int) {
        var parent: IntArray
        var rank: IntArray

        init {
            parent = IntArray(n)
            rank = IntArray(n)
            for (i in 0 until n) parent[i] = i
        }

        fun union(p: Int, q: Int) {
            val rootP = find(p)
            val rootQ = find(q)
            if (rootP == rootQ) return
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ
            } else {
                parent[rootQ] = rootP
                rank[rootP]++
            }
        }

        fun find(p: Int): Int {
            var p = p
            while (parent[p] != p) {
                p = parent[parent[p]]
            }
            return p
        }

        fun connected(p: Int, q: Int): Boolean {
            return find(p) == find(q)
        }

        fun reset(p: Int) {
            parent[p] = p
            rank[p] = 0
        }
    }
}

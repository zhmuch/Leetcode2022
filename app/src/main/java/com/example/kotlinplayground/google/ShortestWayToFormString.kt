package com.example.kotlinplayground.google

/**
 * 1055. Shortest Way to Form String
 * https://leetcode.com/problems/shortest-way-to-form-string/
 */
class ShortestWayToFormString {

    /**
     * Solution 1,
     *
     * greedy,
     *
     * match as much as possible
     *
     * to optimize, can build map for source, to know the next position for a certain char
     * (use binary search to speed up)
     */
    fun shortestWay(source: String, target: String): Int {
        val sourceLength = source.length

        var sourceIndex: Int = sourceLength
        var count = 0

        for (targetIndex in target.indices) {
            val char: Char = target[targetIndex]

            var cur = 0
            while (cur < sourceLength) {
                if (sourceIndex >= sourceLength) {
                    sourceIndex = 0
                    count++
                }

                if (char == source[sourceIndex]) {
                    sourceIndex++
                    break
                }

                sourceIndex++
                cur++
            }
            if (cur == sourceLength) {
                return -1
            }
        }
        return count
    }

    /**
     * Solution 2,
     *
     * KMP ??
     *
     * construct a state machine
     */
}

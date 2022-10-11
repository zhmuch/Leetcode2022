package com.example.kotlinplayground.google

import java.util.LinkedList

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
class MinimumRemoveToMakeValidParentheses {

    /**
     * Solution 1:
     *
     * Straight forward
     */
    fun minRemoveToMakeValid(s: String): String {

        val cs = s.toCharArray()
        var validCount = 0
        var left = 0

        for (c in cs) {
            if ('(' == c) {
                left++
            } else if (')' == c) {
                if (left > 0) {
                    validCount++
                    left--
                }
            }
        }

        var leftCount = validCount
        var rightCount = validCount

        val result = CharArray(cs.size) { ' ' }
        var index = 0

        for (c in cs) {
            when (c) {
                '(' -> {
                    if (leftCount > 0) {
                        result[index] = c
                        index++
                        leftCount--
                    }
                }
                ')' -> {
                    if (leftCount >= rightCount) {
                        // do nothing
                    } else if (rightCount > 0) {
                        result[index] = c
                        index++
                        rightCount--
                    }
                }
                else -> {
                    result[index] = c
                    index++
                }
            }
        }

        return String(result).trim()
    }

    /**
     * Solution 2:
     *
     * Stack to store valid position for left and right
     */
}

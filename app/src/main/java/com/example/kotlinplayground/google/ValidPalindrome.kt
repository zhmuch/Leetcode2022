package com.example.kotlinplayground.google

/**
 * 125. Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/
 */
class ValidPalindrome {

    /**
     * Solution 1
     *
     * reverse the string
     * should be identical
     */

    /**
     * Solution 2
     *
     * two pointer
     */
    fun isPalindrome(s: String): Boolean {
        val c = s.toCharArray()

        var l = 0
        var r = c.size - 1

        while (l < r) {
            if (!c[l].isLetterOrDigit()) {
                l++
                continue
            }
            if (!c[r].isLetterOrDigit()) {
                r--
                continue
            }
            if (c[l].toLowerCase() != c[r].toLowerCase()) {
                return false
            }
            l++
            r--
        }

        return true
    }
}

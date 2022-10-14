package com.example.kotlinplayground.google

/**
 * 647. Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/
 */
class PalindromicSubstrings {

    /**
     * Solution
     *
     * Same as 5. Longest Palindromic Substring
     */
    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) return 0
        var count = 0
        for (i in s.indices) {
            count += expandAroundCenter(s, i, i)
            count += expandAroundCenter(s, i, i + 1)
        }
        return count
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        var count = 0
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            count++
            l--
            r++
        }
        return count
    }
}

package com.example.kotlinplayground.google

/**
 * 5. Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
class LongestPalindromicSubstring {

    /**
     * Solution 1:
     *
     * Brute force,
     * 1. start from every point,
     * 2. search both direction
     */
//    fun longestPalindrome(s: String): String {
//        val c = s.toCharArray()
//        var maxCount = 0
//        var maxLeft = -1
//        var maxRight = -1
//
//        for (i in s.indices) {
//            var res1 = expandBothSide(c, i, i)
//            var res2 = expandBothSide(c, i, i + 1)
//        }
//
//        // ...
//    }
//
//    private fun expandBothSide(c: CharArray, l: Int, r: Int): IntArray {
//        var left = l
//        var right = r
//
//        while (left >= 0 && right < c.size && c[left] == c[right]) {
//            left--
//            right++
//        }
//
//        if (left < 0 || right >= c.size) {
//            left++
//            right--
//        }
//
//        return IntArray(2).also {
//            it[0] = left
//            it[1] = right
//        }
//    }
    open fun longestPalindrome(s: String?): String? {
        if (s == null || s.length < 1) return ""
        var start = 0
        var end = 0
        for (i in 0 until s.length) {
            val len1 = expandAroundCenter(s, i, i)
            val len2 = expandAroundCenter(s, i, i + 1)
            val len = Math.max(len1, len2)
            if (len > end - start) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var L = left
        var R = right
        while (L >= 0 && R < s.length && s[L] == s[R]) {
            L--
            R++
        }
        return R - L - 1
    }

    /**
     * Solution 2:
     *
     * Dynamic Programming
     *
     * dp[i][j] meaning if substring [i..j] is palindromic
     *
     * dp[i][j] = di[i + 1][j - 1] && s[i] == s[j]
     */

    /**
     * Solution 3: Longest Common Substring
     *
     * We could see that the longest common substring method fails when there exists a reversed
     * copy of a non-palindromic substring in some other part of SS. To rectify this, each time
     * we find a longest common substring candidate, we check if the substring’s indices are the
     * same as the reversed substring’s original indices. If it is, then we attempt to update the
     * longest palindrome found so far; if not, we skip this and find the next candidate.
     */
}

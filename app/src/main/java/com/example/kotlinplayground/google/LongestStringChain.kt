package com.example.kotlinplayground.google

/**
 * 1048. Longest String Chain
 * https://leetcode.com/problems/longest-string-chain/
 */
class LongestStringChain {

    /**
     * Solution 1:
     *
     * top-down recursion
     */
    fun longestStrChain(words: Array<String>): Int {
        val maxLength = HashMap<String, Int>()

        for (word in words) {
            subStrFinder(word, words, maxLength)
        }

        var max = 0
        for (word in words) {
            max = Math.max(max, maxLength[word]!!)
        }

        return max
    }

    private fun subStrFinder(
        word: String,
        words: Array<String>,
        maxLength: HashMap<String, Int>
    ): Int {
        if (word.isEmpty()) {
            return 0
        }

        if (maxLength.contains(word)) {
            return maxLength[word]!!
        }

        var max = 0
        for (i in word.indices) {
            val subWord = word.removeRange(i, i + 1)
            if (words.contains(subWord)) {
                max = Math.max(max, subStrFinder(subWord, words, maxLength))
            }
        }

        maxLength[word] = Math.max(1, max + 1)

        return maxLength[word]!!
    }

    /**
     * Solution 2:
     *
     * Trie
     */
}

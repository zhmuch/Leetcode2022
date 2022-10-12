package com.example.kotlinplayground.google

/**
 * 299. Bulls and Cows
 *
 * https://leetcode.com/problems/bulls-and-cows/
 */
class BullsAndCows {

    /**
     *
     * Solution 1
     *
     * Straight forward
     * cound the number of each digit
     */
    fun getHint(secret: String, guess: String): String {
        val ZERO = '0'

        val s = IntArray(10) { 0 }
        val g = IntArray(10) { 0 }

        val sArray = secret.toCharArray()
        val gArray = guess.toCharArray()

        var bulls = 0
        var cows = 0

        for (i in sArray.indices) {
            if (sArray[i] == gArray[i]) {
                bulls++
            } else {
                s[sArray[i] - ZERO]++
                g[gArray[i] - ZERO]++
            }
        }

        for (i in s.indices) {
            cows += Math.min(s[i], g[i])
        }

        return "$bulls" + "A" + "$cows" + "B"
    }

    /**
     * Approach 1: HashMap: Two Passes
     */

    /**
     * Approach 2: One Pass
     * Initialize the hashmap to count characters. During the iteration,
     * secret string gives a positive contribution, and guess - negative contribution.
     */
}

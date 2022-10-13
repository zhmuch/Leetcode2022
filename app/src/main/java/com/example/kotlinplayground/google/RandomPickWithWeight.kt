package com.example.kotlinplayground.google

import kotlin.random.Random

/**
 * 528. Random Pick with Weight
 */
class RandomPickWithWeight(w: IntArray) {

    /**
     * Solution:
     *
     * Binary search
     */
    private val weights: IntArray

    init {
        var prev = 0
        weights = IntArray(w.size) { w[it] }
        for (i in 1 until weights.size) {
            weights[i] += weights[i - 1]
        }
    }

    fun pickIndex(): Int {
        val random = Random.nextInt(0, weights.last())
        return select(random, 0, weights.size - 1)
    }

    private fun select(target: Int, l: Int, r: Int): Int {
        if (l == r) {
            return l
        }
        val mid = (l + r) / 2
        return if (weights[mid] >= target) {
            select(target, l, mid)
        } else {
            select(target, mid + 1, r)
        }
    }
}

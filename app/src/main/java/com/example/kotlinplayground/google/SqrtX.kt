package com.example.kotlinplayground.google

/**
 * 69. Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/
 */
class SqrtX {

    /**
     * Binary search
     */
    fun mySqrt(x: Int): Int {
        return mySqrt(x.toLong(), 0, x.toLong())
    }

    private fun mySqrt(x: Long, l: Long, r: Long): Int {
        if (l == r) {
            return l.toInt()
        }
        val mid = (l + r) / 2 + 1
        return if (mid * mid > x) {
            mySqrt(x, l, mid - 1)
        } else {
            mySqrt(x, mid, r)
        }
    }

    /**
     * Solution 2:
     *
     * Newton's Method
     * One of the best and widely used methods to compute sqrt is Newton's Method.
     * Here we'll implement the version without the seed trimming to keep things simple.
     * However, seed trimming is a bit of math and lot of fun,
     * so here is a link if you'd like to dive in.
     */
}

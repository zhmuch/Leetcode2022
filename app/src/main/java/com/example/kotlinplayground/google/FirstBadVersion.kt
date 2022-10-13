package com.example.kotlinplayground.google

/**
 * 278. First Bad Version
 *
 * https://leetcode.com/problems/first-bad-version/
 */
class FirstBadVersion {

    /**
     * Solution
     *
     * binary search
     * (git bisect)
     *
     * bottom-up
     */
    fun firstBadVersion(n: Int) : Int {
        var start: Long = 1.toLong()
        var end: Long = n.toLong()

        while (start != end) {
            val mid = (start + end) / 2
            if (isBadVersion(mid.toInt())) {
                end = mid
            } else {
                start = mid + 1
            }
        }

        return start.toInt()
    }

    private fun isBadVersion(ran: Int) = Math.random() > ran
}

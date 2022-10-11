package com.example.kotlinplayground.google

import java.util.LinkedList
import java.util.Queue

/**
 * 362. Design Hit Counter
 *
 * https://leetcode.com/problems/design-hit-counter/
 */
class DesignHitCounter {

    /**
     * Solution 1:
     *
     * Binary Tree, with attribute: hits = # hits before current time
     */

    /**
     * Solution 2:
     *
     * Straight forward?
     */
    val queue: Queue<Int> = LinkedList()

    fun hit(timestamp: Int) {
        queue.offer(timestamp)
    }

    fun getHits(timestamp: Int): Int {
        while (queue.isNotEmpty() && queue.peek()!! < timestamp - 300) {
            queue.poll()
        }
        return queue.size
    }

    /**
     * Solution 3:
     *
     * Approach #2: Using Deque with Pairs
     */
}

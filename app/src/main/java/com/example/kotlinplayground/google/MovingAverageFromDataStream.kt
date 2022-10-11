package com.example.kotlinplayground.google

import java.util.*

/**
 * 346. Moving Average from Data Stream
 *
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */
class MovingAverageFromDataStream(size: Int) {

    val size = size
    val queue: Queue<Int> = LinkedList()
    var sum: Double = 0.0
    var count: Int = 0

    /**
     * Solution,
     *
     * Straight forward,
     *
     * keep a queue of window, and calculate the sum
     */
    fun next(`val`: Int): Double {
        count++
        sum += `val`
        queue.offer(`val`)

        if (count > size) {
            sum -= queue.poll()
            count--
        }

        return sum / count
    }

    /**
     * Approach 1: Array or List
     * Approach 2: Double-ended Queue
     * Approach 3: Circular Queue with Array
     */
}
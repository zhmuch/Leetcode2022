package com.example.kotlinplayground.google

import java.util.LinkedList

/**
 * 295. Find Median from Data Stream
 *
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
class FindMedianFromDataStream {

    /**
     * Approach 1: Simple Sorting
     */
    val array = LinkedList<Int>()

    fun addNum(num: Int) {
        array.add(num)
        array.sort()
    }

    fun findMedian(): Double {
        val size = array.size
        return if (size.rem(2) == 1) {
            array[size / 2].toDouble()
        } else {
            (array[size / 2 - 1] + array[size / 2]).toDouble() / 2
        }
    }

    /**
     * Approach 2: Insertion Sort
     */

    /**
     * Approach 3: Two Heaps
     *
     * - If we could maintain direct access to median elements at all times,
     * then finding the median would take a constant amount of time.
     * - If we could find a reasonably fast way of adding numbers to our containers,
     * additional penalties incurred could be lessened.
     *
     * A max-heap to store the smaller half of the input numbers
     * A min-heap to store the larger half of the input numbers
     */

    /**
     * Approach 4: Multiset and Two Pointers
     *
     * Self-balancing Binary Search Trees (like an AVL Tree) have some very interesting properties.
     * They maintain the tree's height to a logarithmic bound. Thus inserting a new element has
     * reasonably good time performance.
     */
}

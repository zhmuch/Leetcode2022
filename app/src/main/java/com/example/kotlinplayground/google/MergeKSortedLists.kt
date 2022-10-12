package com.example.kotlinplayground.google

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue

/**
 * 23. Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
class MergeKSortedLists {

    /**
     * Solution 1:
     *
     * 1. get all elements
     * 2. sort
     * 3. construct new list nodes
     */

    /**
     * Solution 2:
     *
     * 1. Divide and conquer
     * 2. Merge them as pairs
     */

    /**
     * Solution 3:
     *
     * 1. Maintain an min heap
     * 2. keep track of all possible list node from coming lists
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue<ListNode> { node1, node2 ->
            node1.`val` - node2.`val`
        }

        // init
        for (node in lists) {
            if (node != null) {
                minHeap.offer(node)
            }
        }

        if (minHeap.isEmpty()) {
            return null
        }

        // head node
        val result = minHeap.poll()
        if (result!!.next != null) {
            minHeap.offer(result.next)
        }
        var curr = result

        while (minHeap.isNotEmpty()) {
            val next = minHeap.poll()
            curr!!.next = next
            curr = next
            if (curr!!.next != null) {
                minHeap.offer(curr.next)
            }
        }

        return result
    }

    data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

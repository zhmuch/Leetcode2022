package com.example.kotlinplayground.google

/**
 * 92. Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
class ReverseLinkedListII {

    /**
     * Solution 1,
     *
     * get position of left and right,
     * reverse left and right
     */

    /**
     * Solution 2,
     *
     * Straight forward,
     *
     * 1. traverse to left
     * 2. reverse traverse from left to right
     */
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var curr: ListNode? = head
        var prev: ListNode? = null

        for (i in 1 until left) {
            prev = curr
            curr = curr?.next
        }

        // node before reverse
        val reverseStartNode = curr
        val beforeReverse = prev
        for (i in left..right) {
            var next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
        }
        val reverseEndNode = prev
        val afterReverse = curr

        beforeReverse?.next = reverseEndNode
        reverseStartNode?.next = afterReverse

        return if (reverseStartNode == head) {
            reverseEndNode
        } else {
            head
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

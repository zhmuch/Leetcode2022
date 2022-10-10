package com.example.kotlinplayground.google

/**
 * 876. Middle of the Linked List
 *
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
class MiddleOfTheLinkedList {

    /**
     * Solution 1:
     *
     * Find the number of nodes
     */

    /**
     * Solution 2:
     *
     * Fast and Slow pointer
     */
    fun middleNode(head: ListNode?): ListNode? {
        var fast = head
        var slow = head

        while (fast?.next?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
        }

        if (fast?.next != null) {
            slow = slow?.next
        }

        return slow
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

package com.example.kotlinplayground.google

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ReverseLinkedList {
    /**
     * Solution:
     *
     * Straight-forward
     */
    fun reverseList(head: ListNode?): ListNode? {
        var curr = head
        var next = curr?.next
        curr?.next = null

        while (next != null) {
            val n = next.next
            next.next = curr
            curr = next
            next = n
        }

        return curr
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

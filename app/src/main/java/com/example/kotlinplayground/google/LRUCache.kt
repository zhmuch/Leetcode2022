package com.example.kotlinplayground.google

/**
 * 146. LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/
 */

/**
 * Solution: Hashmap + DoubleLinkedList
 *
 * keep updating the list when get access to item in the list
 */

/**
 * Solution 2:
 *
 * The first two operations in O(1) time are provided by the standard hashmap,
 * and the last one - by linked list.
 */
class LRUCache(capacity: Int) :
    LinkedHashMap<Int?, Int?>(capacity, 0.75f, true) {

    val capacity = capacity

    fun get(key: Int): Int {
        return super.getOrDefault(key, -1)!!
    }

    fun put(key: Int, value: Int) {
        super.put(key, value)
    }

     override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>?): Boolean {
        return size > capacity
    }
}

package com.example.kotlinplayground.google

import kotlin.random.Random

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
class InsertDeleteGetRandomO {

    /**
     * Solution 1:
     *
     * linked hashset
     */
    val set = LinkedHashSet<Int>()

    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    fun getRandom(): Int {
//        val index = Random.nextInt(set.size)
//        return set.elementAt(index)
        return set.random()
    }

    /**
     * Solution 2:
     *
     * HashMap + ArrayList
     */
}

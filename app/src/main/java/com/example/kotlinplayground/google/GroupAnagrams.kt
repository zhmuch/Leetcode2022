package com.example.kotlinplayground.google

import java.util.Hashtable
import java.util.LinkedList

/**
 * 49. Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/
 */
class GroupAnagrams {

    /**
     * Solution 1,
     *
     * sort each string as its representation
     * use hashtable to perform union-find
     */
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = LinkedList<LinkedList<String>>()
        val table = Hashtable<String, LinkedList<String>>()

        for (str in strs) {
            val key = str.getStrKey()
            if (table.containsKey(key)) {
                table[key]!!.add(str)
            } else {
                table[key] = LinkedList<String>().also { it.add(str) }
            }
        }

        result.addAll(table.values)

        return result
    }

    private fun String.getStrKey(): String {
        val ori = this.toCharArray()
        ori.sort()
        return String(ori)
    }

    /**
     * Approach 2: Categorize by Count
     */
}

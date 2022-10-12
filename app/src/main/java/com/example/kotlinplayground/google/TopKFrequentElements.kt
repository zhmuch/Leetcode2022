package com.example.kotlinplayground.google

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Hashtable
import java.util.PriorityQueue

/**
 * 347. Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopKFrequentElements {

    /**
     * Solution 1:
     *
     * 1. create LinkedHashtable
     * 2. first iteration, get number for each elements
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val table = Hashtable<Int, Int>()
        for (num in nums) {
            if (table.containsKey(num)) {
                table[num] = table[num]!! + 1
            } else {
                table[num] = 1
            }
        }

        val maxHeap = PriorityQueue<Int> { i1, i2 ->
            table[i2]!! - table[i1]!!
        }
        for (key in table.keys) {
            maxHeap.offer(key)
        }

        return IntArray(k) {
            maxHeap.poll()!!
        }
    }

    /**
     * Solution 2:
     *
     * quick select
     */
}
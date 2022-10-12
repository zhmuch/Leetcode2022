package com.example.kotlinplayground.google

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Hashtable
import java.util.PriorityQueue

/**
 * 692. Top K Frequent Words
 *
 * https://leetcode.com/problems/top-k-frequent-words/
 */
class TopKFrequentWords {

    /**
     * Solution 1,
     *
     * hashmap to count the number
     * min-queue to find the top k freq words
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val table = Hashtable<String, Int>()
        for (word in words) {
            table[word] = table.getOrDefault(word, 0) + 1
        }

        val maxHeap = PriorityQueue<String> { s1, s2 ->
            if (table[s1]!! != table[s2]!!) {
                table[s2]!! - table[s1]!!
            } else {
                s1.compareTo(s2)
            }
        }
        for (word in table.keys) {
            maxHeap.offer(word)
        }

        return List<String>(k) {
            maxHeap.poll()!!
        }
    }

    /**
     * Solution 2,
     *
     * divide and conquer, quick select
     */

    /**
     * Solution 3,
     *
     * Interesting thought:
     * Approach 4: Bucket Sorting + Trie
     * Since we need to sort k elements by comparison
     * (for more about sorting, see this explore card),
     * we have to turn to non-comparison sorting such as bucket/counting sorting to
     * determine potential k elements with max frequencies.
     *
     * For the words with the same frequency, we store them together in a trie
     * (for more about trie, seethis explore card).
     * By traversing a trie in a pre-order DFS way, we can get all words in the trie in
     * a lexicographical order.
     */
}

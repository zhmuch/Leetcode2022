package com.example.kotlinplayground.google

import java.util.Deque
import java.util.Hashtable
import java.util.LinkedList

/**
 * 127. Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/
 */
class WordLadder {

    /**
     * Solution 1:
     *
     * BFS + hashtable
     *
     * pre-calculate a distance map
     */
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val table = Hashtable<String, WordNode>()

        for (word in wordList) {
            table[word] = WordNode(word)
        }
        val begin = WordNode(beginWord)
        table[beginWord] = begin

        for (tuple in table) {
            tuple.value.connectToAdjacent(wordList, table)
        }
        begin.connectToAdjacent(wordList, table)

        if (!table.containsKey(endWord)) {
            return 0
        }

        var queue: Deque<WordNode> = LinkedList()
        queue.offer(begin)
        var distance = 0
        while (queue.isNotEmpty()) {
            distance++
            val tmp: Deque<WordNode> = LinkedList()
            while (queue.isNotEmpty()) {
                val curr = queue.poll()!!
                if (curr.word == endWord) {
                    return distance
                }
                if (table.containsKey(curr.word)) {
                    tmp.addAll(curr.neighbors)
                    table.remove(curr.word)
                }
            }
            queue = tmp
        }
        return 0
    }

    private fun WordNode.connectToAdjacent(wordList: List<String>, table: Hashtable<String, WordNode>) {
        for (word in wordList) {
            if (word == this.word) {
                continue
            }
            if (areAdjacent(this.word, word)) {
                this.neighbors.add(table[word]!!)
            }
        }
    }

    private fun areAdjacent(str1: String, str2: String): Boolean {
        var count = 0
        for (i in str1.indices) {
            if (str1[i] != str2[i]) {
                count++
            }
        }

        return count == 1
    }

    data class WordNode(
        val word: String,
        val neighbors: MutableList<WordNode> = LinkedList()
    )
    /**
     * Solution 2:
     *
     * BFS,
     * check every possble transform: 'a' -> 'z'
     * https://github.com/zhmuch/LeetCode/blob/master/%23127%20Word%20Ladder%203.0.java
     */
}

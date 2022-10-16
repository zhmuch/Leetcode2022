package com.example.kotlinplayground.google

/**
 * 68. Text Justification
 *
 * https://leetcode.com/problems/text-justification/
 */
class TextJustification {

    /**
     * Solution 1:
     *
     * Straight forward
     * findRight: Then we greedily try to go as far right as possible until we fill our current line.
     * Then we justify one line at a time.
     * justify: In all cases we pad the right side with spaces until we reach max width for the line;
     * If it's one word then it is easy, the result is just that word.
     * If it's the last line then the result is all words separated by a single space.
     * Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space until it is gone.
     */
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {

    }
}

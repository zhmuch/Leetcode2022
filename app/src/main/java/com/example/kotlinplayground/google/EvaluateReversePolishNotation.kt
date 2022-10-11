package com.example.kotlinplayground.google

import kotlin.collections.ArrayDeque

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
class EvaluateReversePolishNotation {

    /**
     * Using stack
     */
    fun evalRPN(tokens: Array<String>): Int {
        val numbers = ArrayDeque<Int>()

        for (string in tokens) {
            if (string.isNumber()) {
                numbers.addFirst(string.toInt())
            } else {
                val b = numbers.removeFirst()
                val a = numbers.removeFirst()
                val c = when (string) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    else -> Int.MIN_VALUE
                }
                numbers.addFirst(c)
            }
        }
        return numbers.removeFirst()
    }

    private fun String.isNumber() =
        when (this) {
            "+", "-", "*", "/" -> false
            else -> true
        }
}

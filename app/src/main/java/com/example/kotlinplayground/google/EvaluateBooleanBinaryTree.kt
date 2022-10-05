package com.example.kotlinplayground.google

/**
 * 2331. Evaluate Boolean Binary Tree
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
 */
class EvaluateBooleanBinaryTree {

    /**
     * Solution 1:
     * Non-Recursive binary tree traverse
     * Using stack
     */

    /**
     * Solution 2:
     * Recursive binary tree traverse
     * 0: False
     * 1: True
     * 2: OR
     * 3: AND
     */
    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }

        return if (root.isLeaf()) {
            root.`val`.toBoolean()
        } else {
            val leftChild = evaluateTree(root.left)
            val rightChild = evaluateTree(root.right)
            if (root.`val` == 2) {
                leftChild || rightChild
            } else {
                leftChild && rightChild
            }
        }
    }

    private fun TreeNode.isLeaf() = this.left == null && this.right == null

    private fun Int.toBoolean() = when(this) {
        0 -> false
        1 -> true
        else -> false
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

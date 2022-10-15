package com.example.kotlinplayground.google

import java.util.*


/**
 * 297. Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
class SerializeAndDeserializeBinaryTree {

    /**
     * Solution 1:
     *
     * DFS,
     *
     * insert elements into the middle of the string
     */

    /**
     * Solution 2:
     *
     * BFS
     *
     *
     */
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val n = "null"
        val sep = ","
        val dq: Queue<TreeNode> = LinkedList()
        dq.offer(root)
        var size = 0
        var cur: TreeNode?
        val sb = StringBuilder()

        while (!dq.isEmpty()) {
            size = dq.size
            for (i in 0 until size) {
                cur = dq.poll()
                if (cur != null) {
                    sb.append(cur.`val`)
                    dq.offer(cur.left)
                    dq.offer(cur.right)
                } else {
                    sb.append(n)
                }
                sb.append(sep)
            }
        }
        return sb.toString()
    }

    fun deserialize(data: String): TreeNode? {
        if (data == null || data.isEmpty()) return null
        val vals: List<String> = data.split(",")
        if (vals == null || vals.isEmpty()) return null

        val n = "null"
        val root = TreeNode(vals[0].toInt())
        var cur: TreeNode
        var next: TreeNode
        val dq: Deque<TreeNode> = ArrayDeque()
        var size = 0
        var index = 1
        dq.offer(root)

        while (!dq.isEmpty()) {
            size = dq.size
            for (i in 0 until size) {
                cur = dq.poll()
                var j = index
                while (j < index + 2 && j < vals.size) {
                    if (vals[j] == n) {
                        if (j % 2 == 1) {
                            cur.left = null
                        } else {
                            cur.right = null
                        }
                    } else {
                        next = TreeNode(vals[j].toInt())
                        dq.offer(next)
                        if (j % 2 == 1) {
                            cur.left = next
                        } else {
                            cur.right = next
                        }
                    }
                    ++j
                }
                index += 2
            }
        }

        return root
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

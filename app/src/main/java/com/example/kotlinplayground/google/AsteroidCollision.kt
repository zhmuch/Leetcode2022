package com.example.kotlinplayground.google

/**
 * 735. Asteroid Collision
 *
 * https://leetcode.com/problems/asteroid-collision/
 */
class AsteroidCollision {

    /**
     * Solution 1:
     *
     * Stack
     */
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val record: ArrayDeque<Int> = ArrayDeque()

        for (asteroid in asteroids) {
            var newComing = asteroid
            while (record.isNotEmpty()) {
                if (newComing == Int.MAX_VALUE) {
                    break
                }
                if (newComing > 0) {
                    record.addFirst(newComing)
                    break
                } else {
                    // [newComing] is negative
                    var peek = record.removeFirst()
                    if (peek < 0) {
                        record.addFirst(peek)
                        record.addFirst(newComing)
                        break
                    } else {
                        if (peek == -newComing) {
                            newComing = Int.MAX_VALUE
                            break
                        } else if (peek > -newComing) {
                            newComing = peek
                        } else {
                            // do nothing
                        }
                    }
                }
            }
            if (newComing != Int.MAX_VALUE && record.isEmpty()) {
                record.addFirst(newComing)
            }
        }
        return IntArray(record.size) { record.removeLast() }
    }

    /**
     * Solution 2:
     * Traverse by pair until all left have same direction
     */
}

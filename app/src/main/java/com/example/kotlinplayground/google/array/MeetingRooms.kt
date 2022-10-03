package com.example.kotlinplayground.google.array

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue

/**
 * 252 Meeting Rooms I
 * https://leetcode.com/problems/meeting-rooms/
 */
class MeetingRooms {

    /**
     * Solution 1:
     *
     * Create an array contains all time unit, fill time unit with each intervals
     * if conflict, then return [false]
     * else return [true]
     */

    /**
     * Solution 2:
     *
     * 1. Put the element in the priority heap with custom comparator
     * 2. Put all intervals into the heap
     * 3. Pop up intervals one by one
     * 4. Check if there is any conflict
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        val intervalsPool = PriorityQueue<Interval> { interval1, interval2 ->
            interval1.startTime - interval2.startTime
        }

        // Construct priority heap for intervals
        for (interval in intervals) {
            val newInterval = Interval(interval[0], interval[1])
            intervalsPool.add(newInterval)
        }

        var lastAvailableTime = -1
        // Pop up all intervals to check if there is any conflict
        while (intervalsPool.isNotEmpty()) {
            val currentInterval = intervalsPool.poll()
            if (currentInterval.startTime < lastAvailableTime) {
                return false
            } else {
                lastAvailableTime = currentInterval.endTime
            }
        }
        return true
    }

    data class Interval(
        val startTime: Int,
        val endTime: Int
    )
}

package com.example.kotlinplayground.google

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.LinkedList
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

/**
 * 253 Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
class MeetingRoomsII {

    /**
     * Solution 1:
     *
     * Create an array contains all time unit, fill time unit with each intervals
     * keep track of maximum room needed at same time
     */

    /**
     * Solution 2:
     *
     * 1. Put the element in the priority heap with custom comparator
     * 2. Put all intervals into the heap
     * 3. Pop up intervals one by one
     * 4. keep track of maximum room needed at same time
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val intervalsPool = PriorityQueue<Interval> { interval1, interval2 ->
            interval1.startTime - interval2.startTime
        }

        // Construct priority heap for intervals
        for (interval in intervals) {
            val newInterval = Interval(interval[0], interval[1])
            intervalsPool.add(newInterval)
        }

        var maxNumberOfRooms = 0
        var inUseRoomEndTimes: MutableList<Int> = LinkedList<Int>()
        // Pop up all intervals
        while (intervalsPool.isNotEmpty()) {
            val currentInterval = intervalsPool.poll()
            // Remove expired rooms
            inUseRoomEndTimes = inUseRoomEndTimes.removeExpiredEndTimes(currentInterval.startTime)
            // Add a new room for current one
            inUseRoomEndTimes.add(currentInterval.endTime)
            maxNumberOfRooms = Math.max(maxNumberOfRooms, inUseRoomEndTimes.size)

        }
        return maxNumberOfRooms
    }

    private fun MutableList<Int>.removeExpiredEndTimes(targetTime: Int): MutableList<Int> {
        return this.filter { it > targetTime } as MutableList<Int>
    }

    data class Interval(
        val startTime: Int,
        val endTime: Int
    )

    /**
     * Solution 3:
     *
     * 1. Ignore the bond of a start time and end time,
     * 2. Only check how many "room event" is ongoing
     */
    fun minMeetingRoomsII(intervals: Array<IntArray>): Int {
        val intervalsSize = intervals.size
        val startTimes = Array(intervalsSize) { -1 }
        val endTimes = Array(intervalsSize) { -1 }

        // Construct start and end times array
        for (i in 0 until intervalsSize) {
            startTimes[i] = intervals[i][0]
            endTimes[i] = intervals[i][1]
        }

        // Sort two arrays
        startTimes.sort()
        endTimes.sort()

        var maxRoom = 0
        var endTimeIndex = 0
        //
        for (i in 0 until intervalsSize) {
            if (startTimes[i] < endTimes[endTimeIndex]) {
                maxRoom++
            } else {
                endTimeIndex++
            }
        }
        return maxRoom
    }
}

/**
 * 2402 Meeting Rooms III
 * https://leetcode.com/problems/meeting-rooms-iii/
 */
class MeetingRoomsIII {

    private val INVALID_RESULT = -1

    /**
     * Solution 1:
     *
     * 1. Put all intervals in priority queue.
     * 2. Keep track of all rooms.
     * 3. Keep track of delayed events.
     * 4. Pop up interval one by one
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
            // Construct priority queue for meetings
        val meetingsPool = PriorityQueue<Meeting> { meeting1, meeting2 ->
            meeting1.startTime - meeting2.startTime
        }
        for (meeting in meetings) {
            meetingsPool.add(Meeting(meeting[0], meeting[1]))
        }

        // Construct all rooms
        val rooms = List(n) { i -> Room(i) }

        while(meetingsPool.isNotEmpty()) {
            val nextMeeting = meetingsPool.poll()
            val nextRoom = rooms.findNextAvailableRoom(nextMeeting.startTime)
            nextRoom.apply {
                nextAvailableTime = Math.max(nextAvailableTime, nextMeeting.startTime) +
                        nextMeeting.duration()
                count++
            }
        }

        return rooms.findMostBookedRoom()
    }

    data class Room(
        val index: Int,
        var nextAvailableTime: Int = -1,
        var count: Int = 0
    )

    data class Meeting(
        val startTime: Int,
        val endTime: Int
    )

    private fun List<Room>.findNextAvailableRoom(startTime: Int): Room {
        for (i in 0 until this.size) {
            if (this[i].nextAvailableTime <= startTime) {
                return this[i]
            }
        }
        var nextTime = Int.MAX_VALUE
        var index = -1
        for (i in 0 until this.size) {
            if (this[i].nextAvailableTime < nextTime) {
                nextTime = this[i].nextAvailableTime
                index = i
            }
        }
        return this[index]
    }

    private fun List<Room>.findMostBookedRoom(): Int {
        var mostBookedIndex = -1
        var mostBookedTimes = -1
        this.forEach {
            if (it.count > mostBookedTimes) {
                mostBookedIndex = it.index
                mostBookedTimes = it.count
            }
        }
        return mostBookedIndex
    }

    private fun Meeting.duration(): Int = this.endTime - this.startTime
}

package merge_intervals

import java.util.*

// link: https://leetcode.com/problems/meeting-rooms-ii/

fun main() {
    val interval1 = arrayOf(
        intArrayOf(0, 30),
        intArrayOf(5, 10),
        intArrayOf(15, 20)
    )
    val interval2 = arrayOf(
        intArrayOf(7, 10),
        intArrayOf(2, 4)
    )

    println("Min meeting rooms: ${minMeetingRooms(interval1)}")
    println("Min meeting rooms: ${minMeetingRooms(interval2)}")
}

fun minMeetingRooms(intervals: Array<IntArray>): Int {
    if (intervals.isEmpty()) return 0
    //Arrays.sort(intervals) { a, b -> a[0] - b[0] }
    //val intervals = intervals.sortedWith(compareBy { it[0] })
    val start = IntArray(intervals.size)
    val end = IntArray(intervals.size)

    for (i in intervals.indices) {
        start[i] = intervals[i][0]
        end[i] = intervals[i][1]
    }

    Arrays.sort(start)
    Arrays.sort(end)

    var (s, e, usedRooms) = listOf(0, 0, 0)

    while (s < intervals.size) {
        if (start[s] >= end[e]) {
            usedRooms--
            e++
        }
        usedRooms++
        s++
    }

    return usedRooms
}


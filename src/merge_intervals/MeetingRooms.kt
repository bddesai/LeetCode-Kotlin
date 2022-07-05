package merge_intervals

// link : https://leetcode.com/problems/meeting-rooms/

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

    println("Can attend meetings? ${canAttendMeetings(interval1)}")
    println("Can attend meetings? ${canAttendMeetings(interval2)}")
}


fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
    if (intervals.size == 1) return true
    val sorted = intervals.sortedWith(compareBy { it[0] })

    for (i in 1 until sorted.size) {
        /* if the end time of i-1 interval matches
        * with start of i interval,
        * then he can attend the meeting
        */
        if (sorted[i-1][1] > sorted[i][0]) {
            return false
        }
    }
    return true
}

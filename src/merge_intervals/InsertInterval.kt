package merge_intervals

// link: https://leetcode.com/problems/insert-interval/

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(6, 9)
    )

    insert1(intervals, intArrayOf(2, 5))!!.forEach {
        println("${it[0]}, ${it[1]}")
    }
}

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    // intervals is already sorted
    var (newStart, newEnd, i, n) = listOf(newInterval[0], newInterval[1], 0, intervals.size)
    var result = mutableListOf<IntArray>()

    // add initial intervals
    while (i < n && intervals[i][1] < newStart) {
        result.add(intervals[i++])
    }

    // merge newInterval
    while (i < n && intervals[i][0] <= newEnd) {
        newStart = Math.min(newStart, intervals[i][0])
        newEnd = Math.max(newEnd, intervals[i][1])
        i++
    }
    result.add(intArrayOf(newStart, newEnd))

    // add all intervals after newInterval
    while (i < n)
        result.add(intervals[i++]);

    return result.toTypedArray()
}

fun insert1(intervals: Array<IntArray>, newIntervall: IntArray): Array<IntArray>? {
    val (STR, END) = listOf(0, 1)
    var newInterval = newIntervall

    //val result: MutableList<IntArray> = ArrayList()
    val result = mutableListOf<IntArray>()
    for (interval in intervals) {
        if (newInterval[END] < interval[STR]) {
            result.add(newInterval)
            newInterval = interval
        } else if (interval[END] < newInterval[STR]) {
            result.add(interval)
        } else {
            newInterval[STR] = Math.min(newInterval[STR], interval[STR])
            newInterval[END] = Math.max(newInterval[END], interval[END])
        }
    }
    result.add(newInterval)
    return result.toTypedArray()
}

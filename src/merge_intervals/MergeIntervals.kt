package merge_intervals

import kotlin.math.max

// link : https://leetcode.com/problems/merge-intervals/

fun main() {
    val intervals = arrayOf(
        intArrayOf(8, 10),
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(15, 18)
    )

    merge(intervals).forEach {
        println("${it[0]}, ${it[1]}")
    }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sortedIntervals = intervals.sortedWith(compareBy { it[0] })

//    sortedIntervals.forEach {
//        println("${it[0]}, ${it[1]}")
//    }

    val result = mutableListOf<IntArray>()
    for (interval in sortedIntervals) {
        if(result.isEmpty() || result.last()[1] < interval[0]){
            result.add(interval)
        }
        else {
            result.last()[1] = max(result.last()[1], interval[1])
        }
    }

    return result.toTypedArray()
}


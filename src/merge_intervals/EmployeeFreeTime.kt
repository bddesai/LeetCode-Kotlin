package merge_intervals

import java.util.Collections


fun main() {
    val data = arrayListOf(
        arrayListOf(
            Interval(1, 2),
            Interval(5, 6)
        ),
        arrayListOf(
            Interval(1, 3)
        ),
        arrayListOf(
            Interval(4, 10)
        )
    )

    employeeFreeTimes(data).forEach {
        println("${it.start}, ${it.end}")
    }
}

fun employeeFreeTimes(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
    val allSchedules = mutableListOf<Interval>()

    // populate all individual intervals in 1 list
    for (person in schedule)
        allSchedules.addAll(person)

    // sort arraylist with start values
    Collections.sort(allSchedules, compareBy { it.start })

    // merge intervals
    val mergedList = mutableListOf<Interval>()
    var currStart = allSchedules[0].start
    var currEnd = allSchedules[0].end
    for (i in 1 until allSchedules.size) {
        val interval = allSchedules[i]
        if (interval.start <= currEnd) {
            currEnd = Math.max(currEnd, interval.end)
        } else{
            mergedList.add(Interval(currStart, currEnd))
            currStart = interval.start
            currEnd = interval.end
        }
    }
    // add the last remaining element
    mergedList.add(Interval(currStart, currEnd))

    // build a free time list
    val freeTimeList = mutableListOf<Interval>()
    for (i in 1 until mergedList.size){
        if(mergedList[i].start > mergedList[i-1].end)
            freeTimeList.add(Interval(mergedList[i-1].end, mergedList[i].start))
    }

    return freeTimeList as ArrayList<Interval>
}

class Interval {
    var start: Int = 0
    var end: Int = 0

    constructor(_start: Int, _end: Int) {
        start = _start
        end = _end
    }
}
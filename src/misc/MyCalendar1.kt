package misc

import java.util.*

// link : https://leetcode.com/problems/my-calendar-i/

fun main() {
    val calendar = MyCalendar()
    println(calendar.book(10, 20))
    println(calendar.book(15, 25))
    println(calendar.book(20, 30))
}

class MyCalendar() {

    // you take the events that can be booked in to a collection,
    var calendar: TreeMap<Int, Int> = TreeMap()

    fun book(start: Int, end: Int): Boolean {
        val prev = calendar.floorKey(start)
        val next = calendar.ceilingKey(start)
        if ((prev == null || calendar[prev]!! <= start) &&
            (next == null || end <= next)) {
            calendar[start] = end
            return true
        }
        return false
    }
}

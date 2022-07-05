package sliding_window

import java.util.*


// link : https://leetcode.com/problems/moving-average-from-data-stream/submissions/

fun main() {

    val list = listOf(1, 10, 3, 5)
    val movingAverage = MovingAverage(3)

    list.forEach {
        print("${movingAverage.next(it)}\t")
    }

//    print(movingAverage.next(1)) // return 1.0 = 1 / 1
//    print(movingAverage.next(10)) // return 5.5 = (1 + 10) / 2
//    print(movingAverage.next(3)) // return 4.66667 = (1 + 10 + 3) / 3
//    print(movingAverage.next(5)) // return 6.0 = (10 + 3 + 5) / 3
}

class MovingAverage(val size: Int) {

    var q: Queue<Int> = LinkedList<Int>()
    var totalSoFar = 0.0

    fun next(value: Int): Double {

        if (q.size == size) {
            totalSoFar -= q.poll()
        }

        q.add(value)
        totalSoFar += value

        return totalSoFar / q.size
    }
}
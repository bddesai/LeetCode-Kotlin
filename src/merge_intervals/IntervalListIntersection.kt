package merge_intervals

// link: https://leetcode.com/problems/interval-list-intersections/submissions/

fun main() {
    val firstArray = arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25))
    val secondArray = arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))

    intervalIntersection(firstArray, secondArray).forEach {
        println("${it[0]}, ${it[1]}")
    }
}

fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    if (firstList.isEmpty() || secondList.isEmpty())
        return emptyArray()

    val (start, end) = listOf(0, 1)

    var (aPtr, bPtr) = listOf(0, 0)

    val result = mutableListOf<IntArray>()

    while (aPtr < firstList.size && bPtr < secondList.size) {
        val first = Math.max(firstList[aPtr][start], secondList[bPtr][start])
        val second = Math.min(firstList[aPtr][end], secondList[bPtr][end])

        if (first <= second)
            result.add(intArrayOf(first, second))

        if (firstList[aPtr][end] > secondList[bPtr][end])
            bPtr++
        else
            aPtr++

    }

    return result.toTypedArray()
}


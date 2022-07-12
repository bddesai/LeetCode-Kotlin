package sorting

import java.util.*

// link: https://leetcode.com/problems/top-k-frequent-elements/

fun main() {
    topKFrequent(intArrayOf(1,1,1,2,2,3), 2).forEach { print("$it ") }
    topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentToString()
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {

    // key - num, value - frequency
    val map = mutableMapOf<Int, Int>()

    // max heap - max frequency at the top and sorted by frequency in descending order
    val heap = PriorityQueue<IntArray>(compareBy { it[1] })

    for (i in nums.indices) {
        map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
    }

    println(map)

    for (key in map.keys) {
        val first = key
        val second = map[key]

        heap.add(intArrayOf(first, second!!))

        if (heap.size > k) {
            val polledValue = heap.poll()
            println("polledValue = ${polledValue.contentToString()}")
        }
    }

    //print("heap = $heap")
    val result = IntArray(k)
    var i = k-1
    while (!heap.isEmpty()) {
        result[i] = heap.poll()[0]
        i--
    }

    return result
}
package sorting

import java.util.*

// link: https://leetcode.com/problems/top-k-frequent-elements/

fun main() {
    topKFrequent2(intArrayOf(1, 1, 1, 2, 2, 3), 2).forEach { print("$it ") }
    println("")
    topKFrequent2(intArrayOf(1, 2, 3, 4, 4), 2).forEach { print("$it ") }
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {

    // key - num, value - frequency
    val countMap = mutableMapOf<Int, Int>()

    // max heap - max frequency at the top and sorted by frequency in descending order
    val heap = PriorityQueue<IntArray>(compareBy { it[1] })

    for (i in nums.indices) {
        countMap[nums[i]] = countMap.getOrDefault(nums[i], 0) + 1
    }

    println(countMap)

    for (key in countMap.keys) {
        val first = key
        val second = countMap[key]

        heap.add(intArrayOf(first, second!!))

        if (heap.size > k) {
            val polledValue = heap.poll()
            println("polledValue = ${polledValue!!.contentToString()}")
        }
    }

    //print("heap = $heap")
    val result = IntArray(k)
    var i = k - 1
    while (!heap.isEmpty()) {
        result[i] = heap.poll()[0]
        i--
    }

    return result
}


fun topKFrequent2(nums: IntArray, k: Int): IntArray {
    val numsMap = hashMapOf<Int, Int>()
    val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })

    nums.forEach { num ->
        numsMap[num] = numsMap.getOrDefault(num, 0) + 1
    }

    for ((key, value) in numsMap) {
        priorityQueue.add(Pair(key, value))
    }

    val res = IntArray(k)
    for (i in 0 until k) {
        res[i] = priorityQueue.poll().first
    }
    return res
}
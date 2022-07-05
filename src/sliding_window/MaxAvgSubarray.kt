package sliding_window

import java.util.*

// link: https://leetcode.com/problems/maximum-average-subarray-i/


fun main() {
    val nums = intArrayOf(1, 12, -5, -6, 50, 3)
    val k = 4
    println(findMaxAverage(nums, k))

    val nums1 = intArrayOf(-1)
    val k1 = 1
    println(findMaxAverage(nums1, k1))
}


fun findMaxAverage(nums: IntArray, k: Int): Double {
    var windowSum = 0.0

    for (i in 0 until k) windowSum += nums[i]

    var maxWindowSum = windowSum

    for (i in k until nums.size) {
        windowSum += nums[i] - nums[i - k]

        maxWindowSum = Math.max(maxWindowSum, windowSum)
    }

    return maxWindowSum / k
}

// solution using queue
fun findMaxAverage1(nums: IntArray, k: Int): Double {
    var (maxAvg, totalSoFar) = listOf(0.0, 0.0)
    val q = LinkedList<Int>()

    for (i in 0 until nums.size) {
        if (q.size == k) {
            totalSoFar -= q.poll()
        }

        q.add(nums[i])
        totalSoFar += nums[i]

        maxAvg = Math.max(maxAvg, (totalSoFar / q.size))
    }

    return maxAvg
}
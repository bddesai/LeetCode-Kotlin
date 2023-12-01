package two_pointer

// 11. Container With Most Water
// Link: https://leetcode.com/problems/container-with-most-water/description/

fun main() {
    println(
        containerWithMostWater(
            intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        )
    )
}

fun containerWithMostWater(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1

    var maxCapacity = 0
    while (start < end) {
        var currCapacity: Int
        if (nums[start] > nums[end]) {
            currCapacity = (end - start) * nums[end]
            end--
        } else if (nums[start] < nums[end]) {
            currCapacity = (end - start) * nums[start]
            start++
        } else {
            currCapacity = (end - start) * nums[end]
            start++
            end--
        }

        maxCapacity = maxOf(currCapacity, maxCapacity)
    }

    return maxCapacity
}
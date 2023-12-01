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

// NeetCode => O(n)
fun containerWithMostWater(nums: IntArray): Int {
    var (left, right) = 0 to nums.size - 1

    var maxCapacity = 0
    while (left < right) {
        val area = (right-left) * minOf(nums[left], nums[right])
        maxCapacity = maxOf(maxCapacity, area)

        if(nums[left] < nums[right]) left++
        else right--
    }
    return  maxCapacity
}

//  My Solution => O(n)
fun containerWithMostWater2(nums: IntArray): Int {
    var (start, end) = 0 to nums.size - 1

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
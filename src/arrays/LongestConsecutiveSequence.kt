package arrays

import kotlin.test.assertEquals


// link: https://leetcode.com/problems/longest-consecutive-sequence/
fun main() {
    val testCases = listOf(
        intArrayOf(100, 4, 200, 1, 3, 2) to 4,
        intArrayOf() to 0,
        intArrayOf(0) to 1
    )

    for ((input, result) in testCases) {
        println("Result for ${input.contentToString()} = $result : ${result == longestConsecutive(input)}")
        assertEquals(result, longestConsecutive(input))
    }
}

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var maxLength = 0
    val set = nums.toHashSet()

    for (num in nums) {
        if (!set.contains(num - 1)) {
            var currentLength = 1
            var currentNum = num

            while (set.contains(currentNum + 1)){
                currentNum++
                currentLength++
            }

            maxLength = maxOf(currentLength, maxLength)
        }
    }
    return maxLength
}


// Brute Force - O(n log n)
fun longestConsecutiveBruteForce(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    if (nums.size == 1) return 1

    nums.sort()

    var count = 1
    val listOfCounts = mutableListOf<Int>()

    for (i in 1 until nums.size) {
        if (nums[i] == nums[i - 1] + 1) {
            count++
            listOfCounts.add(count)
        } else {
            count = 1
        }
    }

    return listOfCounts.toIntArray().max()!!
}


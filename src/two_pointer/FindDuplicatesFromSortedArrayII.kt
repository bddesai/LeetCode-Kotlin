package two_pointer

// 80. Remove Duplicates from Sorted Array II
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

fun main() {
    val tests = arrayOf(
        intArrayOf(1, 1, 1, 2, 2, 3) to 5,
        intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3) to 7
    )

    for(test in tests){
        println("${test.first.contentToString()} = ${test.second}")
        println(removeDuplicatesFromSortedArrayII(test.first) == test.second)
    }
}

fun removeDuplicatesFromSortedArrayII(nums: IntArray): Int {
    var i = 0
    for (n in nums) {
        if (i < 2 || n > nums[i - 2]) {
            nums[i] = n
            i++
        }
    }
    return i
}

fun removeDuplicatesFromSortedArrayII2(nums: IntArray): Int {
    if (nums.size <= 2) return nums.size

    var slow = 2
    for (fast in 2 until nums.size) {
        if (nums[slow - 2] != nums[fast]) {
            nums[slow] = nums[fast]
            slow++
        }
    }

    return slow
}


package two_pointer

// 26. Remove Duplicates from Sorted Array
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

fun main() {
    val arr1 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    println(removeDuplicates(arr1))

    val arr2 = intArrayOf(11)
    println(removeDuplicates(arr2))
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var count = 1
    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1]) {
            nums[count] = nums[i]
            count++
        }
    }
    println(nums.contentToString())
    return count
}

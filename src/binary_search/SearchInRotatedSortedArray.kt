package binary_search

// link: https://leetcode.com/problems/search-in-rotated-sorted-array/

fun main() {
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), target = 0))
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), target = 3))
    println(search(intArrayOf(1), target = 0))
    println(search(intArrayOf(40, 41, 42, 43, 19, 20, 21, 22, 23), target = 42))
}


fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (nums[mid] == target)
            return mid

        // Check if left part is sorted
        if (nums[mid] >= nums[start]) {
            if (target >= nums[start] && target < nums[mid])
                end = mid - 1  // move left
            else
                start = mid + 1 // move right
        }
        // Right part is sorted
        else {
            if (target > nums[mid] && target <= nums[end])
                start = mid + 1  // move right
            else
                end = mid - 1  // move left
        }
    }
    return -1
}
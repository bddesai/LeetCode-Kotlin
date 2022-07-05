package cycle_sort


// link: https://leetcode.com/problems/find-the-duplicate-number/

fun main() {
    println(findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
}

fun findDuplicate(nums: IntArray): Int {
    var i = 0
    // sort array in place using cycle sort
    while (i < nums.size) {

        if (nums[i] != i + 1) {
            val correct = nums[i] - 1
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct)
            } else {
                return nums[i]
            }
        } else
            i++
    }

    return -1
}
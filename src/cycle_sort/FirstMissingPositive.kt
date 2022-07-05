package cycle_sort


// link: https://leetcode.com/problems/first-missing-positive/

fun main() {
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
}

fun firstMissingPositive(nums: IntArray): Int {
    var i = 0

    while (i < nums.size) {
        val correct = nums[i] - 1
        //  number not in place        ignore negative
        if (nums[i] > 0 && nums[i] != nums[correct] && nums[i] <= nums.size)
            swap(nums, i, correct)
        else
            i++
    }
    for (j in nums.indices) {
        if (nums[j] != j + 1) {
            return j + 1
        }
    }
    return -1
}
package cycle_sort

// link: https://leetcode.com/problems/set-mismatch/

fun main() {
    val result = findErrorNums(intArrayOf(1, 2, 2, 4))
    println(result.contentToString())
}

fun findErrorNums(nums: IntArray): IntArray {
    // cycle sort
    var i = 0
    while (i < nums.size) {
        val correct = nums[i] - 1
        if (nums[i] != nums[correct])
            swap(nums, i, correct)
        else
            i++
    }
    // find duplicate and missing number
    for (i in 0 until nums.size) {
        if (nums[i] != i + 1) {
            return intArrayOf(nums[i], i + 1)
        }
    }

    return intArrayOf(-1)
}



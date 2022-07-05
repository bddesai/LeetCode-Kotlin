package cycle_sort

// link: https://leetcode.com/problems/find-all-duplicates-in-an-array/

fun main() {
    println(findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
}

fun findAllDuplicates(arr: IntArray): List<Int> {
    var i = 0
    // sort array in place using cycle sort
    while (i < arr.size) {
        var correct = arr[i] -1
        if (arr[i] != arr[correct]) {
            swap(arr, i, correct)
        } else {
            i++
        }
    }
    // find missing numbers
    val list = ArrayList<Int>()
    // for (j in 0 until arr.size){
    for (j in arr.indices) { // 0 .. n-1
        if (arr[j] != j + 1) {
            list.add(arr[j])
        }
    }
    return list
}

fun findDuplicates(nums: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    var pointer = 0

    while (pointer < nums.size) {
        val index = Math.abs(nums[pointer]) - 1

        when {
            (nums[index] < 0) -> result.add(Math.abs(nums[pointer]))
            else -> nums[index] *= -1
        }

        pointer++
    }
    return result
}

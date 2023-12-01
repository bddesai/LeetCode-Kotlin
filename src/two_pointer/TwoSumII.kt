package two_pointer

// 167. Two Sum II - Input Array Is Sorted
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

fun main(){
    val testCases = arrayOf(
        intArrayOf(2, 7, 11, 15) to 9,
        intArrayOf(3, 2, 4) to 6,
        intArrayOf(3, 3) to 6,
        intArrayOf(-1, -2, -3, -4, -5) to -8,
        intArrayOf(1, 5, 3, 7, 9) to 10,
        intArrayOf(2, 1, 5, 3) to 4,
        intArrayOf(0, 4, 3, 0) to 0,
        intArrayOf(-3, 4, 5, 90) to 0
    )

    var count = 0
    for ((nums, target) in testCases) {
        count++
        val result = twoSumII(nums, target)
        println("$count. Input: nums = ${nums.joinToString()}, target = $target")
        println("> Output: ${result.joinToString()} ")
    }
}


fun twoSumII(numbers: IntArray, target: Int): IntArray {

    var start = 0
    var end = numbers.size-1

    while(start < end){
        var currentSum = numbers[start] + numbers[end]
        when {
            currentSum == target -> return intArrayOf(start+1, end+1)
            currentSum > target -> end--
            else -> start++
        }
    }
    return intArrayOf()
}
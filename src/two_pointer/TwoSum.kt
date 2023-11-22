package two_pointer


fun main() {
//    val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
//    println(result?.joinToString())  // Output: 0, 1 (or similar, based on the input array's content)

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
        val result = twoSum(nums, target)
        println("$count. Input: nums = ${nums.joinToString()}, target = $target")
        if (result != null) {
            println("> Output: ${result.joinToString()} ")
        } else {
            println("! Output: No two sum solution")
        }
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray? {
    if (nums.size <= 1) {
        return null
    }

    val map = mutableMapOf<Int, Int>()
    for ((i, num) in nums.withIndex()) {
        val complement = target - num
        map[complement]?.let {
            return intArrayOf(it, i)
        }
        map[num] = i
    }

    return null
}

fun twoSumSimple(nums: IntArray, target: Int): IntArray {

    var map = mutableMapOf<Int, Int>()

//    for(i in nums.indices){
//        val complement = target - nums[i]
//        map[complement]?.let {
//            return intArrayOf(it, i)
//        }
//        map[nums[i]] = i
//    }

    nums.forEachIndexed { index, num ->
        val current = map[target - num]
        current?.let {
            return intArrayOf(current, index)
        }
        map[num] = index
    }

    return intArrayOf()
}
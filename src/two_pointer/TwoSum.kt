package two_pointer


fun main() {
    val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(result?.joinToString())  // Output: 0, 1 (or similar, based on the input array's content)
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
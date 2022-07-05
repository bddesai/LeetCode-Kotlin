package two_pointer

// link: https://leetcode.com/problems/3sum-smaller/

fun main() {
    val list = intArrayOf(3,5,2,8,1)
    val target = 7

    print(threeSumSmaller(list, target))
}

fun threeSumSmaller(nums: IntArray, target: Int): Int {

    nums.sort()

    var tripletCount = 0

    for (i in 0 until nums.size) {
        var low = i + 1
        var high = nums.size - 1

        while (low < high) {
            val sum = nums[i] + nums[low] + nums[high]

            if (sum < target) {
                tripletCount += high - low
                low++
            } else {
                high--
            }

        }
    }
    return tripletCount
}


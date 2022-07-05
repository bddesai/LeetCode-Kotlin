package two_pointer


// link: https://leetcode.com/problems/3sum-closest/

fun main() {
    val list = intArrayOf(-1, 2, 1, -4)
    val target = 1

    print(threeSumClosest(list, target))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {

    nums.sort()

    var diff = Integer.MAX_VALUE

    for (i in 0 until nums.size) {

        var l = i + 1
        var r = nums.size - 1

        while (l < r) {

            val sum = nums[i] + nums[l] + nums[r]
            if (Math.abs(target - sum) < Math.abs(diff)) {
                diff = target - sum
            }

            if (sum < target) {
                l++
            } else {
                r--
            }
        }
    }

    return target - diff
}
package two_pointer

import java.util.ArrayList
import java.util.Arrays


// link: https://leetcode.com/problems/3sum/

fun main() {
    // target = 0
    val list = intArrayOf(-1, 0, 1, 2, -1, -4)

    print(threeSum(list))

}

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()

    val resList = ArrayList<List<Int>>()

    for (i in 0 until nums.size) {

        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        var j = i + 1
        var k = nums.size - 1



        while (j < k) {

            if(k < nums.size-1 && nums[k] == nums[k+1]){
                k--
                continue
            }

            val sum = nums[i] + nums[j] + nums[k]
            when {
                sum > 0 -> k--
                sum < 0 -> j++
                else -> {
                    resList.add(arrayListOf(nums[i], nums[j], nums[k]))
                    j++
                    k--
                }
            }
        }
    }

    return resList
}
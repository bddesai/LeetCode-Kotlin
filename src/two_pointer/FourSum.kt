package two_pointer

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val list = intArrayOf(1, 0, -1, 0, -2, 2)
    val target = 0

    print(fourSum(list, target))
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()

    return kSum(nums, target, 0, 4)
}

fun kSum(nums: IntArray, target: Int, start: Int, k: Int): ArrayList<ArrayList<Int>> {
    val res = ArrayList<ArrayList<Int>>()

    if (start == nums.size) return res

    // There are k remaining values to add to the sum. The
    // average of these values is at least target / k.
    val average = target / k

    // We cannot obtain a sum of target if the smallest value
    // in nums is greater than target / k or if the largest
    // value in nums is smaller than target / k.
    if (nums[start] > average || nums[nums.size - 1] < average)
        return res

    if (k == 2) return twoSum(nums, target, start)

    for (i in start until nums.size) {
        if (i == start || nums[i - 1] != nums[i]) {

            // subset type = List<Int>
            val subset = kSum(nums, target - nums[i], i + 1, k - 1)

            subset.forEach {
                res.add(arrayListOf(nums[i]))

                res[res.size - 1].addAll(it) // add the subset
            }
        }
    }

    return res
}


fun twoSum(nums: IntArray, target: Int, start: Int): ArrayList<ArrayList<Int>> {
    val resList = ArrayList<ArrayList<Int>>()

    var low = start
    var high = nums.size - 1

    while (low < high) {
        val currentSum = nums[low] + nums[high]

        if (currentSum < target ||
                (low > start && nums[low] == nums[low - 1])) {
            low++
        } else if (currentSum > target ||
                (high < nums.size - 1 && nums[high] == nums[high + 1])) {
            high--
        } else {

            resList.add(
                    ArrayList(arrayListOf(nums[low], nums[high]))
            )
            low++
            high--
        }
    }

    return resList
}




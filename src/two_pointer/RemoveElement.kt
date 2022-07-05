package two_pointer

// https://leetcode.com/problems/remove-element/

fun main() {
    println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}

fun removeElement(nums: IntArray, value: Int): Int {

    var i = 0
    var n: Int = nums.size
    while (i < n) {
        if (nums[i] == value) {
            nums[i] = nums[n - 1]
            // reduce array size by one
            n--
        } else {
            i++
        }
    }
    return n
}

